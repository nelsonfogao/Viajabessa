package com.example.viajabessa

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.viajabessa.model.Pacotes
import kotlinx.android.synthetic.main.detalhes_fragment.*

class DetalhesFragment : Fragment() {

    private lateinit var viewModel: DetalhesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(DetalhesViewModel::class.java)
        val root = inflater.inflate(R.layout.detalhes_fragment, container, false)
        viewModel.pacotes.observe(viewLifecycleOwner, Observer {
            if (it != null)
                preencherDadosPacotes(it)
        })
        return root
    }

    private fun preencherDadosPacotes(pacotesDetail: Pacotes) {
        textViewDetalhesNome.text = pacotesDetail.nome
        textViewDetalhesValor.text = pacotesDetail.valor.toString()
        textViewDetalhesDescricao.text = pacotesDetail.descricao
    }
}