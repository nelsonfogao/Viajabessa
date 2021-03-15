package com.example.viajabessa.api

import com.example.viajabessa.api.service.ProjectService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private var instance: Retrofit? = null
    private fun getRetrofit(): Retrofit{
        if (instance == null)
            instance = Retrofit
                .Builder()
                .baseUrl("https://private-fe6cb2-viajabessa87.apiary-mock.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return instance as Retrofit
    }

    fun getProjectService(): ProjectService{
        var retrofit:Retrofit = getRetrofit()
        return retrofit.create(ProjectService::class.java)
    }
}