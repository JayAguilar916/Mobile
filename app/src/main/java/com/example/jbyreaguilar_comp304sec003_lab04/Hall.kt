package com.example.jbyreaguilar_comp304sec003_lab04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Hall : AppCompatActivity(), HallAdapter.MyClickListener {
    private lateinit var recyclerviewHall: RecyclerView
    private lateinit var hallType: ArrayList<HallType>
    private lateinit var hallAdapter: HallAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hall)

        recyclerviewHall = findViewById(R.id.recyclerViewHall)

        hallType = ArrayList()
        hallType.add(HallType(R.drawable.hallbalmoralfire, "Balmoral Fire Hall", 43.6856, -79.3947))
        hallType.add(HallType(R.drawable.hallhelliconian, "Heliconian Hall", 43.6717, -79.3933))
        hallType.add(HallType(R.drawable.hallmasaryk, "Masaryk Hall", 43.6411, -79.4328))
        hallType.add(HallType(R.drawable.hallmassey, "Massey Hall", 43.6542, -79.3792))
        hallType.add(HallType(R.drawable.hallosgoode, "Osgoode Hall", 43.6519, -79.3856))

        hallAdapter = HallAdapter(hallType, this@Hall)
        recyclerviewHall.adapter = hallAdapter
        recyclerviewHall.setHasFixedSize(true)
        recyclerviewHall.layoutManager = LinearLayoutManager(this)
    }

    override fun onClick(position: Int, hallType: HallType) {
        val intent = Intent(this, GoogleMapsActivity::class.java)
        intent.putExtra("latitude", hallType.latitude)
        intent.putExtra("longitude", hallType.longitude)
        startActivity(intent)
    }
}