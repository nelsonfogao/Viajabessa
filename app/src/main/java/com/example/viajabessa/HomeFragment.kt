package com.example.viajabessa

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.home_fragment, container, false)
        homeViewModel.pacotes.observe(viewLifecycleOwner, Observer {
            if(!it.isNullOrEmpty())
                recyclerViewListPacotes.adapter = PacotesRecyclerAdapter(it){
                    findNavController().navigate(R.id.detalhesFragment)
                }
                recyclerViewListPacotes.layoutManager = LinearLayoutManager(requireContext())
        })
        return root
    }

}