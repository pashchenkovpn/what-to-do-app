package com.myproject.what_to_do.presentation

import androidx.lifecycle.ViewModel
import com.myproject.what_to_do.domain.GetUsefulActivityUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


class MainViewModel @Inject constructor(private val getUsefulActivityUseCase: GetUsefulActivityUseCase) : ViewModel() {

    private val _state = MutableStateFlow("")
    val state = _state.asStateFlow()

    suspend fun reloadUsefulActivity() {
        _state.value = getUsefulActivityUseCase.execute()?.activity ?: "No activity loaded"
    }
}