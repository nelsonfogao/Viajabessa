package com.example.viajabessa.api.service

import com.example.viajabessa.model.Pacotes
import retrofit2.http.GET
import retrofit2.http.Path

interface ProjectService {
    @GET("pacotes")
    suspend fun all(): List<Pacotes>

    @GET("pacotes/{id}")
    suspend fun show(@Path("id")id:Long): Pacotes

}