package com.suiiz.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.suiiz.R
import com.suiiz.adapters.VehiclesAdapter
import com.suiiz.util.DumyData
import kotlinx.android.synthetic.main.fragment_vehicles.*


class VehiclesFragment : Fragment(R.layout.fragment_vehicles) {

    private lateinit var vehiclesAdapter: VehiclesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vehiclesAdapter = VehiclesAdapter()

        setupRecyclerView(rv)

    }

    private fun setupRecyclerView(rv: RecyclerView){
        vehiclesAdapter = VehiclesAdapter()
        vehiclesAdapter.differ.submitList(DumyData.vehicleList)
        rv.apply {
            adapter = vehiclesAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}