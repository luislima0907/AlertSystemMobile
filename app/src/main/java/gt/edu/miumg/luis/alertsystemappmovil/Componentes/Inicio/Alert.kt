package gt.edu.miumg.luis.alertsystemappmovil.Componentes.Inicio

import gt.edu.miumg.luis.alertsystemappmovil.ManejoDeUsuarios.User

class Alert {
    var state: String = ""
    var typeAlert:String = ""
    var idButton:String = ""
    var idAlert:String = ""
    var user: User = User()
    var userId:String = ""
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    var date:String = ""
    var detail:String = ""

}