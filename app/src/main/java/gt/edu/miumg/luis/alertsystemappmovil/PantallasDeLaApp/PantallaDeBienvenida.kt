package gt.edu.miumg.luis.alertsystemappmovil.PantallasDeLaApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import gt.edu.miumg.luis.alertsystemappmovil.Componentes.Notificacion.NotificationService
import gt.edu.miumg.luis.alertsystemappmovil.Navegacion.ManejoDeLasPantallasDeLaApp
import gt.edu.miumg.luis.alertsystemappmovil.R
import kotlinx.coroutines.delay

@Composable
fun PantallaDeBienvenida(navController: NavController) {
    val context = LocalContext.current
    val alertService = NotificationService(context)

    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.popBackStack()

        if (!FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()) {
            // Si el usuario está autenticado, inicia el servicio de escucha de alertas
            alertService.listenChangesOnAlerts()

            val uid = FirebaseAuth.getInstance().currentUser?.uid ?: ""
            navController.navigate(ManejoDeLasPantallasDeLaApp.PantallaPrincipal.ruta + "/$uid")
        } else {
            navController.navigate(ManejoDeLasPantallasDeLaApp.PantallaConInfoApp.ruta)
        }
    }
    Splash()
}


@Composable
fun Splash(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.celesteClaro)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.nimbusguard),
            contentDescription = "Logo NimbusGuard",
            modifier = Modifier.size(250.dp, 250.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaDeBienvenidaPreview(){
    Splash()
}