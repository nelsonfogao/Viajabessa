package com.example.viajabessa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viajabessa.model.Pacotes
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhes.*

class DetalhesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)
        lateinit var viewModel: DetalhesViewModel
        lateinit var detalhesFactory: DetalhesFactory
        val pacotesId = intent.getBundleExtra("id")
        var id = pacotesId?.getLong("pacotesId")
        detalhesFactory = DetalhesFactory(id!!)
        viewModel = ViewModelProvider(this, detalhesFactory).get(DetalhesViewModel::class.java)
        viewModel.pacotes.observe(this, Observer {
            if (it != null)
                textViewDetalhesNome.text = it.nome
            textViewDetalhesValor.text = it.valor.toString()
            textViewDetalhesDescricao.text = it.descricao
            Picasso.get().load(it.imageUrl)
                .into(imageViewDetalhes)
        })

    }
}