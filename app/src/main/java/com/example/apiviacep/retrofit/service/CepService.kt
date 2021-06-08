package com.example.apiviacep.retrofit.service

import com.example.apiviacep.model.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CepService {
    @GET("ws/{cep}/json")
    fun buscarCep(@Path("cep") cep: String): Call<Endereco>
}