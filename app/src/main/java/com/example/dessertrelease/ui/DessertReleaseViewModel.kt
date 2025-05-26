package com.example.dessertrelease.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.dessertrelease.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DessertReleaseViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DessertReleaseUiState())

    val uiState: StateFlow<DessertReleaseUiState> = _uiState

    fun selectLayout(isLinearLayout: Boolean) {
        _uiState.value = DessertReleaseUiState(isLinearLayout)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                DessertReleaseViewModel()
            }
        }
    }
}

data class DessertReleaseUiState(
    val isLinearLayout: Boolean = true,
    val toggleContentDescription: Int = if (isLinearLayout) R.string.grid_layout_toggle else R.string.linear_layout_toggle,
    val toggleIcon: Int = if (isLinearLayout) R.drawable.ic_grid_layout else R.drawable.ic_linear_layout
)