package gt.edu.miumg.luis.alertsystemappmovil.Navegacion

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import gt.edu.miumg.luis.alertsystemappmovil.Componentes.Inicio.BotonDeAlertaViewModel
import gt.edu.miumg.luis.alertsystemappmovil.Componentes.Inicio.BotonDeAlertaViewModelFactory
import gt.edu.miumg.luis.alertsystemappmovil.ManejoDeUsuarios.UserAuthService
import gt.edu.miumg.luis.alertsystemappmovil.PantallasDeLaApp.PantallaConInfoApp
import gt.edu.miumg.luis.alertsystemappmovil.PantallasDeLaApp.PantallaDeBienvenida
import gt.edu.miumg.luis.alertsystemappmovil.PantallasDeLaApp.PantallaDeInicio
import gt.edu.miumg.luis.alertsystemappmovil.PantallasDeLaApp.PantallaDeLogin
import gt.edu.miumg.luis.alertsystemappmovil.PantallasDeLaApp.PantallaDeNotificacion
import gt.edu.miumg.luis.alertsystemappmovil.PantallasDeLaApp.PantallaDePerfil
import gt.edu.miumg.luis.alertsystemappmovil.PantallasDeLaApp.PantallaDeRegistro
import gt.edu.miumg.luis.alertsystemappmovil.PantallasDeLaApp.PantallaPrincipal
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun navegacionDeLaApp() {
    val navController = rememberNavController()
    val authService = UserAuthService()

    val context = navController.context
    val viewModel: BotonDeAlertaViewModel = viewModel(factory = BotonDeAlertaViewModelFactory(context))
    val buttonStates by viewModel.buttonStates.collectAsState(initial = emptyMap())

    NavHost(navController = navController, startDestination = ManejoDeLasPantallasDeLaApp.PantallaDeBienvenida.ruta) {
        composable(route = ManejoDeLasPantallasDeLaApp.PantallaPrincipal.ruta + "/{uid}",
            arguments = listOf(navArgument("uid") { type = NavType.StringType })) {
            PantallaPrincipal(navController, buttonStates, onButtonStatusChange = { buttonId, isEnabled ->
                viewModel.viewModelScope.launch {
                    viewModel.updateButtonState(buttonId, isEnabled)
                }
            })
        }
        composable(route = ManejoDeLasPantallasDeLaApp.PantallaDeInicio.ruta + "/{uid}",
            arguments = listOf(navArgument("uid") { type = NavType.StringType })) {
            PantallaDeInicio(navController, buttonStates, onButtonStatusChange = { buttonId, isEnabled ->
                viewModel.viewModelScope.launch {
                    viewModel.updateButtonState(buttonId, isEnabled)
                }
            })
        }
        composable(route = ManejoDeLasPantallasDeLaApp.PantallaDeRegistro.ruta) {
            PantallaDeRegistro(navController)
        }
        composable(route = ManejoDeLasPantallasDeLaApp.PantallaDeLogin.ruta) {
            PantallaDeLogin(navController = navController, users = listOf())
        }
        composable(
            route = ManejoDeLasPantallasDeLaApp.PantallaConInfoApp.ruta){
            PantallaConInfoApp(navController)
        }
        composable(route = ManejoDeLasPantallasDeLaApp.PantallaDeNotificacion.ruta) {
            PantallaDeNotificacion(navController =  navController)
        }
        composable(
            route = ManejoDeLasPantallasDeLaApp.PantallaDePerfil.ruta + "/{uid}",
            arguments = listOf(navArgument("uid") { type = NavType.StringType })
        ) {
            val uid = it.arguments?.getString("uid") ?: ""
            PantallaDePerfil(navController = navController, uid = uid, authService = authService)
        }
        composable(route = ManejoDeLasPantallasDeLaApp.PantallaDeBienvenida.ruta){
            PantallaDeBienvenida(navController)
        }
        composable(route = ManejoDeLasPantallasDeLaApp.PantallaConInfoApp.ruta){
            PantallaConInfoApp(navController)
        }
    }
}