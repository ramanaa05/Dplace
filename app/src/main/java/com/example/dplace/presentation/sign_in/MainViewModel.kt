package com.example.dplace.presentation.sign_in

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    private val _infoState = mutableStateOf(InfoState())
    val infoState: State<InfoState> = _infoState

    fun updateCell(cell: Cell){
        infoState.value.copy(loading = true)
        viewModelScope.launch {
            try {
                // Fetch user details
                val response = apiService.updateGrid(cell)
                _infoState.value = _infoState.value.copy(
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                // Handle error
                _infoState.value = _infoState.value.copy(
                    loading = false,
                    error = "Error: ${e.message}"
                )
            }
        }
    }

    fun fetchGrid(cell: Cell){
        infoState.value.copy(loading = true)
        viewModelScope.launch {
            try {
                // Fetch user details
                val response = apiService.getGrid()
                _infoState.value = _infoState.value.copy(
                    grid = response,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                // Handle error
                _infoState.value = _infoState.value.copy(
                    loading = false,
                    error = "Error: ${e.message}"
                )
            }
        }
    }

    data class InfoState(
        val loading: Boolean = false,
        val error: String? = null,
        val grid: Grid = Grid(emptyList())
    )
}