package com.example.jbyreaguilar_comp304sec003_lab04

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HallAdapter(val hallType: ArrayList<HallType>, val listener: MyClickListener): RecyclerView.Adapter<HallAdapter.MyViewHolder>() {

    interface MyClickListener {
        fun onClick(position: Int, hallType: HallType)
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageViewHall: ImageView = itemView.findViewById(R.id.imageViewHall)
        val textViewHall: TextView = itemView.findViewById(R.id.textViewHall)

        init {
            itemView.setOnClickListener{

                val position = adapterPosition
                val hallType = hallType[position]
                listener.onClick(position, hallType)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.hallitem, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hallType = hallType[position]
        holder.textViewHall.text = hallType.name
        holder.imageViewHall.setImageResource(hallType.image)
    }

    override fun getItemCount(): Int {
        return hallType.size
    }
}