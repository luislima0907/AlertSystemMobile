package gt.edu.miumg.luis.alertsystemappmovil.PantallasDeLaApp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import gt.edu.miumg.luis.alertsystemappmovil.Componentes.Login.ContrasenaField
import gt.edu.miumg.luis.alertsystemappmovil.Componentes.Login.CorreoField
import gt.edu.miumg.luis.alertsystemappmovil.Componentes.Login.ImagenLogin
import gt.edu.miumg.luis.alertsystemappmovil.Componentes.PantallaTutorial.fontFamily
import gt.edu.miumg.luis.alertsystemappmovil.ManejoDeUsuarios.User
import gt.edu.miumg.luis.alertsystemappmovil.ManejoDeUsuarios.UserAuthService
import gt.edu.miumg.luis.alertsystemappmovil.ManejoDeUsuarios.Validaciones

@Composable
fun PantallaDeLogin(navController: NavController, users: List<User>) {
    LoginForm(navController, users)
}

@Composable
fun LoginForm(navController: NavController, users: List<User>) {
    // Estados para los campos de correo y contraseña
    val correo = remember { mutableStateOf("") }
    val contrasena = remember { mutableStateOf("") }
    val context = LocalContext.current
    val userAuthService = UserAuthService()


    // Estado para controlar el diálogo de error o éxito
    val showLoginSuccessDialog = remember { mutableStateOf(false) }
    val showLoginErrorDialog = remember { mutableStateOf(false) }
    val uidState = remember { mutableStateOf<String?>(null) }  // Estado para guardar el UID

    val scrollState = rememberScrollState() // Estado para el scroll

    // Validar los campos antes de iniciar sesion
    fun validarCredenciales(
        correo: String,
        contrasena: String,
        context: Context,
        onValidacionFallida: (String) -> Unit
    ): Boolean {
        if (correo.isBlank()) {
            onValidacionFallida("El campo de correo está vacío")
            return false
        }

        if (contrasena.isBlank()) {
            onValidacionFallida("El campo de contraseña está vacío")
            return false
        }

        if (!Validaciones.isValidCorreo(correo)) {
            onValidacionFallida("Correo inválido")
            return false
        }

        return true // Las validaciones han sido exitosas
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 210.dp, bottom = 50.dp)
            .verticalScroll(scrollState), // Habilitar desplazamiento
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Iniciar Sesión",
            //fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            color = Color.Black,
            fontFamily = fontFamily
        )

        Spacer(modifier = Modifier.height(2.dp))

        // Imagen de inicio de sesión
        ImagenLogin()
        Spacer(modifier = Modifier.height(16.dp))

        // Campos de texto para correo y contraseña
        CorreoField(correo)
        ContrasenaField(contrasena)

        Spacer(modifier = Modifier.height(3.dp))

        val userAuthService = UserAuthService() // Crear instancia del servicio de autenticación

        Button(
            onClick = {
                // Ejecutar la función de validación
                if (!validarCredenciales(correo.value, contrasena.value, context) { mensajeError ->
                        Toast.makeText(context, mensajeError, Toast.LENGTH_SHORT).show()
                    }) {
                    return@Button // Detener el flujo si las validaciones fallan
                }

                // Usar Firebase para validar el login
                userAuthService.loginUser(context, correo.value, contrasena.value) { success, uid ->
                    if (success) {
                        uidState.value = uid.toString() // Guardar el UID en el estado
                        showLoginSuccessDialog.value = true
                    } else {
                        showLoginErrorDialog.value = true
                        Toast.makeText(context, "Error al iniciar sesión", Toast.LENGTH_SHORT).show()
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,  // Consistencia en el color del botón
                contentColor = Color.White    // Texto blanco
            )
        ) {
            Text(
                text = "Iniciar Sesión",
                //fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = fontFamily
            )
        }
    }

    // Diálogo de inicio de sesión exitoso
    if (showLoginSuccessDialog.value && uidState.value != null) {
        AlertDialog(
            onDismissRequest = { showLoginSuccessDialog.value = false },
            title = { Text(text = "Inicio de Sesión Exitoso!", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
            text = { Text(text = "¡Bienvenido de nuevo!") },
            confirmButton = {
                Button(
                    onClick = {
                        showLoginSuccessDialog.value = false
                        navController.navigate("pantalla_principal/${uidState.value}") // Navegar solo después de aceptar
                    }
                ) {
                    Text("Aceptar")
                }
            },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        )
    }

    // Diálogo de error de inicio de sesión
    if (showLoginErrorDialog.value) {
        AlertDialog(
            onDismissRequest = { showLoginErrorDialog.value = false },
            title = { Text(text = "Error", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
            text = {
                Text(text = "Correo o contraseña incorrectos. Por favor, inténtalo de nuevo.")
            },
            confirmButton = {
                Button(
                    onClick = {
                        showLoginErrorDialog.value = false
                    }
                ) {
                    Text("Aceptar")
                }
            },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        )
    }
}

fun validarCredenciales(
    correo: String,
    contrasena: String,
    context: Context,
    onValidacionFallida: (String) -> Unit
): Boolean {
    if (correo.isBlank()) {
        onValidacionFallida("El campo de correo está vacío")
        return false
    }

    if (contrasena.isBlank()) {
        onValidacionFallida("El campo de contraseña está vacío")
        return false
    }

    if (!Validaciones.isValidCorreo(correo)) {
        onValidacionFallida("Correo inválido")
        return false
    }

    return true // Las validaciones han sido exitosas
}