package com.example.viajabessa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.pacotes.observe(this, Observer {
            recyclerViewListPacotes.adapter = PacotesRecyclerAdapter(it) {
                    val bundle = bundleOf(
                        "pacotesId" to it.id
                    )
                    intent = Intent(
                        this,
                        DetalhesActivity::class.java
                    )
                    intent.putExtra("id", bundle)
                    startActivity(intent)
                }
            recyclerViewListPacotes.layoutManager = LinearLayoutManager(this)
        })
    }
}
