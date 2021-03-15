package com.example.viajabessa


import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viajabessa.model.Pacotes
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_pacotes.view.*

class PacotesRecyclerAdapter (
    val pacotes: List<Pacotes>,
    val actionClick: (Pacotes) -> Unit
): RecyclerView.Adapter<PacotesRecyclerAdapter.PacotesViewHolder>(){

    class PacotesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textViewNome: TextView = itemView.textViewNome
        val textPreco: TextView = itemView.textViewPreço
        val image: ImageView = itemView.imageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacotesViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.recycler_pacotes,
                parent,
                false
            )

        return PacotesViewHolder(view)
    }

    override fun onBindViewHolder( holder: PacotesViewHolder, position: Int) {
            val pacotes = pacotes[position]
            holder.textViewNome.text = pacotes.nome
            holder.textPreco.text = pacotes.valor.toString()
            Picasso.get().load(pacotes.imageUrl)
            .into(holder.image);

            holder.itemView.setOnClickListener {
                actionClick(pacotes)
            }

        }

    override fun getItemCount(): Int = pacotes.size
}