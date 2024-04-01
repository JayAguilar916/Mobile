package com.example.jbyreaguilar_comp304sec003_lab04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class House : AppCompatActivity(), HouseAdapter.MyClickListener {
    private lateinit var recyclerviewHouse: RecyclerView
    private lateinit var houseType: ArrayList<HouseType>
    private lateinit var houseAdapter: HouseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house)

        recyclerviewHouse = findViewById(R.id.recyclerViewHouse)

        houseType = ArrayList()
        houseType.add(HouseType(R.drawable.houseashbridgeestate, "Jesse Ashbridge House", 43.6656, -79.3217))
        houseType.add(HouseType(R.drawable.houseenochturnerschool, "Enoch Turner Schoolhouse", 43.6531, -79.3614))
        houseType.add(HouseType(R.drawable.housegeorgebrown, "George Brown House", 43.655833, -79.394722))
        houseType.add(HouseType(R.drawable.housemaryperram, "Mary Perram House", 43.6672, -79.3769))
        houseType.add(HouseType(R.drawable.houserupertsimpson, "Rupert Simpson House", 43.66728087976465, -79.36159502741555))

        houseAdapter = HouseAdapter(houseType, this@House)
        recyclerviewHouse.adapter = houseAdapter
        recyclerviewHouse.setHasFixedSize(true)
        recyclerviewHouse.layoutManager = LinearLayoutManager(this)
    }

    override fun onClick(position: Int, houseType: HouseType) {
        val intent = Intent(this, GoogleMapsActivity::class.java)
        intent.putExtra("latitude", houseType.latitude)
        intent.putExtra("longitude", houseType.longitude)
        startActivity(intent)
    }
}