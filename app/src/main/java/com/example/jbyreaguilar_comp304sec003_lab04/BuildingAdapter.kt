package com.example.jbyreaguilar_comp304sec003_lab04

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BuildingAdapter(val buildingType: ArrayList<BuildingType>, val listener: MyClickListener):RecyclerView.Adapter<BuildingAdapter.MyViewHolder>() {

    interface MyClickListener {
        fun onClick(position: Int, buildingType: BuildingType)
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageViewBuilding: ImageView = itemView.findViewById(R.id.imageViewBuilding)
        val textViewBuilding: TextView = itemView.findViewById(R.id.textViewBuilding)

        init {
            itemView.setOnClickListener{

                val position = adapterPosition
                val buildingType = buildingType[position]
                listener.onClick(position, buildingType)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.buildingitem, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val buildingType = buildingType[position]
        holder.textViewBuilding.text = buildingType.name
        holder.imageViewBuilding.setImageResource(buildingType.image)
    }

    override fun getItemCount(): Int {
        return buildingType.size
    }

}