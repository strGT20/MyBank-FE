package com.example.mybank.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybank.data.api.ApiConfig
import com.example.mybank.data.models.PersonalizationState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    // State untuk mengontrol apakah pop-up harus muncul atau tidak
    private val _showConsentDialog = MutableStateFlow(false)
    val showConsentDialog: StateFlow<Boolean> = _showConsentDialog

    init {
        checkConsentStatus()
    }

    private fun checkConsentStatus() {
        // TODO: Nanti cek dari SharedPreferences di sini.
        // Jika belum pernah jawab -> _showConsentDialog.value = true
        // Untuk sekarang kita set true terus agar bisa dites UI-nya:
        _showConsentDialog.value = true
    }

    // Fungsi saat tombol Izinkan (true) atau Tolak (false) diklik
    fun submitPersonalizationConsent(isEnabled: Boolean) {
        viewModelScope.launch {
            // Langsung sembunyikan pop-up agar UI terasa responsif
            _showConsentDialog.value = false

            try {
                val request = PersonalizationState(enabled = isEnabled)
                val response = ApiConfig.userService.setPersonalization(request)

                if (response.isSuccessful) {
                    // TODO: Simpan status "SUDAH_MENJAWAB" ke SharedPreferences
                    // Agar besok-besok pop-up tidak muncul lagi
                } else {
                    // Opsional: Handle error jika gagal dikirim
                }
            } catch (e: Exception) {
                // Opsional: Handle error koneksi internet
            }
        }
    }
}