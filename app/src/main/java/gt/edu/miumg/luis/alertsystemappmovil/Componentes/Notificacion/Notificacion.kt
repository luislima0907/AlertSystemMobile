package gt.edu.miumg.luis.alertsystemappmovil.Componentes.Notificacion

data class Notificacion(
    val alertId: String,
    val estado: String,
    val message: String,
    val alertType: String,
    val latitud: String,
    val longitud: String,
    val timestamp: Long = System.currentTimeMillis()
)