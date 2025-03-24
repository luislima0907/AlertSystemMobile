package gt.edu.miumg.luis.alertsystemappmovil.ManejoDeUsuarios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gt.edu.miumg.luis.alertsystemappmovil.DepYMuni.ValidarCUI

class UserProfileViewModel(
    private val firestoreService: UserFireStoreService,
    private val validarCUI: ValidarCUI
) : ViewModel() {

    // Estado que mantiene al usuario
    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    // Función para cargar el usuario por UID
    fun loadUser(uid: String) {
        // Verifica si los datos ya están cargados
        if (_user.value == null) {
            firestoreService.getUserbyUid(uid) { fetchedUser ->
                _user.value = fetchedUser
            }
        }
    }
}