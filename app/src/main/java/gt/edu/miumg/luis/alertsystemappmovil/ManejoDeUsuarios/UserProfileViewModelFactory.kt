package gt.edu.miumg.luis.alertsystemappmovil.ManejoDeUsuarios

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import gt.edu.miumg.luis.alertsystemappmovil.DepYMuni.ValidarCUI

class UserProfileViewModelFactory(
    private val firestoreService: UserFireStoreService,
    private val validarCUI: ValidarCUI
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserProfileViewModel::class.java)) {
            return UserProfileViewModel(firestoreService, validarCUI) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}