package com.example.jbyreaguilar_comp304sec003_lab04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Theatre : AppCompatActivity(), TheatreAdapter.MyClickListener {
    private lateinit var recyclerviewTheatre: RecyclerView
    private lateinit var theartreType: ArrayList<TheatreType>
    private lateinit var theatreAdapter: TheatreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house)

        recyclerviewTheatre = findViewById(R.id.recyclerViewHouse)

        theartreType = ArrayList()
        theartreType.add(TheatreType(R.drawable.theatreelginandwintergarden, "Elgin & Winter Garden Theatre", 43.6531, -79.3795))
        theartreType.add(TheatreType(R.drawable.theatreenglinton, "Eglinton Theatre", 43.7042, -79.4106))
        theartreType.add(TheatreType(R.drawable.theatreroyalalexandra, "Royal Alexandra Theatre", 43.6472, -79.3875))

        theatreAdapter = TheatreAdapter(theartreType, this@Theatre)
        recyclerviewTheatre.adapter = theatreAdapter
        recyclerviewTheatre.setHasFixedSize(true)
        recyclerviewTheatre.layoutManager = LinearLayoutManager(this)
    }

    override fun onClick(position: Int, theartreType: TheatreType) {
        val intent = Intent(this, GoogleMapsActivity::class.java)
        intent.putExtra("latitude", theartreType.latitude)
        intent.putExtra("longitude", theartreType.longitude)
        startActivity(intent)
    }
}