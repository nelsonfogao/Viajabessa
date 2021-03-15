package com.example.viajabessa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viajabessa.api.ApiClient
import com.example.viajabessa.model.Pacotes
import kotlinx.coroutines.launch

class DetalhesViewModel(
    val pacotesId: Long
) : ViewModel() {

    private val _pacotes = MutableLiveData<Pacotes>()
    val pacotes: LiveData<Pacotes> = _pacotes

    init {
        viewModelScope.launch {
            _pacotes.value = ApiClient.getProjectService().show(pacotesId)
        }
    }
}