package com.suiiz.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.suiiz.R
import com.suiiz.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_vehicles.*

class VehiclesFragment : Fragment(R.layout.fragment_vehicles) {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setupVehicleRv(rv, resources, requireActivity())
        viewModel.setupVehicleVp2(vp2)

        viewModel.vehiclesRecyclerAdapter.setOnItemClickListener {
            when(it.id){
                0 -> findNavController().navigate(R.id.action_vehiclesFragment_to_vehicle_CarsBrandFragment)
            }
        }

    }

}