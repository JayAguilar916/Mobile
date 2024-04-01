package com.example.jbyreaguilar_comp304sec003_lab04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Church : AppCompatActivity(), ChurchAdapter.MyClickListener {
        private lateinit var recyclerviewChurch: RecyclerView
        private lateinit var churchType: ArrayList<ChurchType>
        private lateinit var churchAdapter: ChurchAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_church)

            recyclerviewChurch = findViewById(R.id.recyclerViewChurch)

            churchType = ArrayList()
            churchType.add(ChurchType(R.drawable.churchmetropolitanunited, "Metropolitan United Church", 43.6532, -79.3758))
            churchType.add(ChurchType(R.drawable.churchstandrews, "St. Andrew's Church", 43.6473, -79.3856))
            churchType.add(ChurchType(R.drawable.churchstanneanglican, "St. Anne Anglican Church", 43.650606, -79.430675))
            churchType.add(ChurchType(R.drawable.churchstmarys, "St. Mary's Church", 43.6448, -79.4042))
            churchType.add(ChurchType(R.drawable.churchtrinitystpaulsunited, "Trinity St. Paul United", 43.66620263526117, -79.40551677475405))

            churchAdapter = ChurchAdapter(churchType, this@Church)
            recyclerviewChurch.adapter = churchAdapter
            recyclerviewChurch.setHasFixedSize(true)
            recyclerviewChurch.layoutManager = LinearLayoutManager(this)
        }

        override fun onClick(position: Int, churchType: ChurchType) {
            val intent = Intent(this, GoogleMapsActivity::class.java)
            intent.putExtra("latitude", churchType.latitude)
            intent.putExtra("longitude", churchType.longitude)
            startActivity(intent)
        }
    }