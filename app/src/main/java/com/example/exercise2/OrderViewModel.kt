package com.example.exercise2

import androidx.lifecycle.ViewModel
import com.example.exercise2.data.MahasiswaUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel: ViewModel() {
    private val _nameSTATE = MutableStateFlow(MahasiswaUiState())
    val nameST : StateFlow<MahasiswaUiState> = _nameSTATE.asStateFlow()
    fun setNama(list: MutableList<String>){
        _nameSTATE.update { stateSaatIni -> stateSaatIni.copy(
            nama = list[0],
            nim = list[1],
            konsentrasi = list[2],
            judul = list[3]
        ) }
    }
}
