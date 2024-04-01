package com.example.jbyreaguilar_comp304sec003_lab04

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TheatreAdapter(val theatreType: ArrayList<TheatreType>, val listener: MyClickListener): RecyclerView.Adapter<TheatreAdapter.MyViewHolder>() {

    interface MyClickListener {
        fun onClick(position: Int, theatreType: TheatreType)
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageViewTheatre: ImageView = itemView.findViewById(R.id.imageViewTheatre)
        val textViewTheatre: TextView = itemView.findViewById(R.id.textViewTheatre)

        init {
            itemView.setOnClickListener{

                val position = adapterPosition
                val theatreType = theatreType[position]
                listener.onClick(position, theatreType)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.theatreitem, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val theatreType = theatreType[position]
        holder.textViewTheatre.text = theatreType.name
        holder.imageViewTheatre.setImageResource(theatreType.image)
    }

    override fun getItemCount(): Int {
        return theatreType.size
    }
}