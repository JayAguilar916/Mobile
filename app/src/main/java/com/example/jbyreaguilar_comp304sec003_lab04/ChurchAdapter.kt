package com.example.jbyreaguilar_comp304sec003_lab04

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChurchAdapter(val churchType: ArrayList<ChurchType>, val listener: MyClickListener): RecyclerView.Adapter<ChurchAdapter.MyViewHolder>() {

    interface MyClickListener {
        fun onClick(position: Int, churchType: ChurchType)
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageViewChurch: ImageView = itemView.findViewById(R.id.imageViewChurch)
        val textViewChurch: TextView = itemView.findViewById(R.id.textViewChurch)

        init {
            itemView.setOnClickListener{

                val position = adapterPosition
                val churchType = churchType[position]
                listener.onClick(position, churchType)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.churchitem, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val churchType = churchType[position]
        holder.textViewChurch.text = churchType.name
        holder.imageViewChurch.setImageResource(churchType.image)
    }

    override fun getItemCount(): Int {
        return churchType.size
    }

}