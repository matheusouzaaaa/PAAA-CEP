package com.example.apiviacep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.apiviacep.retrofit.service.CepClientApi

class MainActivity : AppCompatActivity() {

    val cepClientApi: CepClientApi by lazy { // tipo um NEW, mas é só quando realmente for usar.
        CepClientApi()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun consultarCep(view: View){
        val cepEdit = findViewById<EditText>(R.id.editTextTextPersonName)
        val textEstado = findViewById<TextView>(R.id.resposta)
        val cep = cepEdit.text.toString()
        cepClientApi.buscarCep(
            cep,
            onSuccess = {endereco -> textEstado.text = endereco?.uf },
            onFail = {Toast.makeText(this,"Errou",Toast.LENGTH_LONG).show()}
        )
    }
}