package com.example.viajabessa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viajabessa.api.ApiClient
import com.example.viajabessa.model.Pacotes
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _pacotes = MutableLiveData<List<Pacotes>>()
    val pacotes: LiveData<List<Pacotes>> = _pacotes

    init {
        viewModelScope.launch {
            val pacotesList = ApiClient.getProjectService().all()
            _pacotes.value = pacotesList
        }
    }
}