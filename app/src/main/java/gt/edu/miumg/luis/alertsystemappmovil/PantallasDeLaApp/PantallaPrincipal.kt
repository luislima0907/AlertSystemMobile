package gt.edu.miumg.luis.alertsystemappmovil.PantallasDeLaApp

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import gt.edu.miumg.luis.alertsystemappmovil.Componentes.Inicio.BotonDeAlertaViewModel
import gt.edu.miumg.luis.alertsystemappmovil.Componentes.Inicio.BotonDeAlertaViewModelFactory
import gt.edu.miumg.luis.alertsystemappmovil.Componentes.Inicio.ItemDeLaBarra
import gt.edu.miumg.luis.alertsystemappmovil.Componentes.Notificacion.NotificacionRepository
import gt.edu.miumg.luis.alertsystemappmovil.Componentes.PantallaTutorial.fontFamily
import gt.edu.miumg.luis.alertsystemappmovil.ManejoDeUsuarios.UserAuthService
import gt.edu.miumg.luis.alertsystemappmovil.R

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PantallaPrincipal(
    navController: NavController,
    buttonStates: Map<String, Boolean>,
    onButtonStatusChange: (String, Boolean) -> Unit,
) {
    val uid = FirebaseAuth.getInstance().currentUser?.uid ?: ""

    val contadorDeNotificaciones by remember {
        derivedStateOf { NotificacionRepository.obtenerNotificaciones(uid).size }
    }

    barraDeNavegacionInferior(
        navController = navController,
        buttonStates = buttonStates,
        onButtonStatusChange = onButtonStatusChange,
        contadorDeNotificaciones = contadorDeNotificaciones
    )
}



@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun barraDeInformacionSuperior(){
    val context = LocalContext.current.applicationContext
    TopAppBar(
        title = {
            Text(text = "Bienvenido a Nimbus Guard",
                color = Color.Black,
                fontSize = 27.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                fontFamily = fontFamily,
                fontStyle = FontStyle.Italic
            )
        },
        navigationIcon = {
            IconButton(onClick = { Toast.makeText(context, "Icono", Toast.LENGTH_SHORT).show()}) {
                Image(painter = painterResource(id = R.drawable.logoappnimbusguard),
                    contentDescription = "Logo",
                    Modifier.size(80.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun barraDeNavegacionInferior(
    navController: NavController,
    buttonStates: Map<String, Boolean>,
    onButtonStatusChange: (String, Boolean) -> Unit,
    contadorDeNotificaciones: Int
) {
    val context = LocalContext.current
    val viewModel: BotonDeAlertaViewModel = viewModel(factory = BotonDeAlertaViewModelFactory(context))
    val _buttonStates by viewModel.buttonStates.collectAsState(initial = emptyMap())

    val listaDeItemsDeLaBarraDeNavegacion = listOf(
        ItemDeLaBarra("Inicio", Icons.Default.Home, 0),
        ItemDeLaBarra("Perfil", Icons.Default.Person, 0),
        ItemDeLaBarra("Notificaciones", Icons.Default.Notifications, contadorDeNotificaciones)
    )

    var selectedIndex by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                listaDeItemsDeLaBarraDeNavegacion.forEachIndexed { index, itemDeLaBarra ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = {
                            BadgedBox(badge = {
                                if (itemDeLaBarra.contadorDeNotificaciones > 0) {
                                    Badge {
                                        Text(text = itemDeLaBarra.contadorDeNotificaciones.toString())
                                    }
                                }
                            }) {
                                Icon(
                                    imageVector = itemDeLaBarra.icono,
                                    contentDescription = "Icono"
                                )
                            }
                        },
                        label = {
                            Text(text = itemDeLaBarra.texto)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        contenidoDeLaBarraDeNavegacionInferior(
            modifier = Modifier.padding(innerPadding),
            selectedIndex = selectedIndex,
            navController = navController,
            buttonStates = _buttonStates,
            onButtonStatusChange = onButtonStatusChange
        )
        barraDeInformacionSuperior()
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun contenidoDeLaBarraDeNavegacionInferior(
    modifier: Modifier,
    selectedIndex: Int,
    navController: NavController,
    buttonStates: Map<String, Boolean>,
    onButtonStatusChange: (String, Boolean) -> Unit
) {
    when (selectedIndex) {
        0 -> PantallaDeInicio(
            navController = navController,
            buttonStates = buttonStates,
            onButtonStatusChange = onButtonStatusChange
        )
        1 -> {
            val uid = FirebaseAuth.getInstance().currentUser?.uid ?: ""
            val authService = UserAuthService()
            PantallaDePerfil(navController = navController, uid = uid, authService = authService)
        }
        2 -> PantallaDeNotificacion(navController = navController)
    }
}