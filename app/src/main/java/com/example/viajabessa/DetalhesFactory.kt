package com.example.viajabessa

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetalhesFactory (private val pacotesId:Long):ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetalhesViewModel::class.java))
            return DetalhesViewModel(pacotesId) as T
        throw IllegalArgumentException("Classe ViewModel desconhecida.")
    }
}