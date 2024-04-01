package com.example.jbyreaguilar_comp304sec003_lab04

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val landmarkTypeList:ArrayList<LandmarkTypes>, val listener: MyClickListener):RecyclerView.Adapter<Adapter.MyViewHolder>() {
    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)

        init {
            itemView.setOnClickListener{
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun getItemCount(): Int {
        return landmarkTypeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val landmarkType = landmarkTypeList[position]
        holder.textView.text = landmarkType.name
        holder.imageView.setImageResource(landmarkType.image)
    }

    interface MyClickListener{
        fun onClick(position: Int)
    }
}