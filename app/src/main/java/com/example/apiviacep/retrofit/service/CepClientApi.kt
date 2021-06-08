package com.example.apiviacep.retrofit.service

import com.example.apiviacep.model.Endereco
import com.example.apiviacep.retrofit.AppRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CepClientApi (private val cepService: CepService = AppRetrofit().cepService) {
    fun buscarCep(
        cep:String,
        onSuccess: (endereco: Endereco?) -> Unit,
        onFail: (erro: String?) -> Unit
    ){
        cepService.buscarCep(cep).enqueue(object: Callback<Endereco>{ // trata de forma assincrona para não impactar na aplicação depois. para não precisar criar coroutines.
            override fun onFailure(call: Call<Endereco>, t: Throwable) {
                onFail(t.message)
            }

            override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                if(response.isSuccessful){
                    onSuccess(response.body())
                }else{
                    onFail("Erro não identificado")
                }
            }
        })
    }
}