package com.example.jbyreaguilar_comp304sec003_lab04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),Adapter.MyClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var landmarkType: ArrayList<LandmarkTypes>
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        landmarkType = ArrayList()
        landmarkType.add(LandmarkTypes(R.drawable.building,"Building"))
        landmarkType.add(LandmarkTypes(R.drawable.church,"Church"))
        landmarkType.add(LandmarkTypes(R.drawable.hall,"Hall"))
        landmarkType.add(LandmarkTypes(R.drawable.house,"House"))
        landmarkType.add(LandmarkTypes(R.drawable.theatre,"Theatre"))

        adapter = Adapter(landmarkType, this@MainActivity)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onClick(position: Int) {
        when(position){
            0 -> startActivity(Intent(this,Building::class.java))
            1 -> startActivity(Intent(this,Church::class.java))
            2 -> startActivity(Intent(this,Hall::class.java))
            3 -> startActivity(Intent(this,House::class.java))
            4 -> startActivity(Intent(this,Theatre::class.java))
        }
    }
}