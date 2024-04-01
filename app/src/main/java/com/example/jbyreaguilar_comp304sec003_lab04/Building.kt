package com.example.jbyreaguilar_comp304sec003_lab04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Building : AppCompatActivity(), BuildingAdapter.MyClickListener {
    private lateinit var recyclerviewBuilding: RecyclerView
    private lateinit var buildingType: ArrayList<BuildingType>
    private lateinit var buildingAdapter: BuildingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_building)

        recyclerviewBuilding = findViewById(R.id.recyclerViewBuilding)

        buildingType = ArrayList()
        buildingType.add(BuildingType(R.drawable.buildingbirkbeck, "Birkbeck Building", 43.650833, -79.377778))
        buildingType.add(BuildingType(R.drawable.buildingbankofuppercanada, "Bank of Upper Canada", 43.6519444, -79.3708333))
        buildingType.add(BuildingType(R.drawable.buildingdixon, "Dixon Building", 43.6532, -79.3832))
        buildingType.add(BuildingType(R.drawable.buildinggooderham, "Gooderham Building", 43.6480, -79.3744))
        buildingType.add(BuildingType(R.drawable.buildingdominionpublic, "Dominion Public", 43.6461, -79.3781))

        buildingAdapter = BuildingAdapter(buildingType, this@Building)
        recyclerviewBuilding.adapter = buildingAdapter
        recyclerviewBuilding.setHasFixedSize(true)
        recyclerviewBuilding.layoutManager = LinearLayoutManager(this)
    }

    override fun onClick(position: Int, buildingType: BuildingType) {
        val intent = Intent(this, GoogleMapsActivity::class.java)
        intent.putExtra("latitude", buildingType.latitude)
        intent.putExtra("longitude", buildingType.longitude)
        startActivity(intent)
    }


}