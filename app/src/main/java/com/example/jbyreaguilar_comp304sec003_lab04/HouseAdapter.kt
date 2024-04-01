package com.example.jbyreaguilar_comp304sec003_lab04

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HouseAdapter(val houseType: ArrayList<HouseType>, val listener: MyClickListener): RecyclerView.Adapter<HouseAdapter.MyViewHolder>() {

    interface MyClickListener {
        fun onClick(position: Int, houseType: HouseType)
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageViewHouse: ImageView = itemView.findViewById(R.id.imageViewHouse)
        val textViewHouse: TextView = itemView.findViewById(R.id.textViewHouse)

        init {
            itemView.setOnClickListener{

                val position = adapterPosition
                val houseType = houseType[position]
                listener.onClick(position, houseType)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.houseitem, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val houseType = houseType[position]
        holder.textViewHouse.text = houseType.name
        holder.imageViewHouse.setImageResource(houseType.image)
    }

    override fun getItemCount(): Int {
        return houseType.size
    }
}