package com.suiiz.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.suiiz.R
import com.suiiz.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_vehicle_cars_brand.*

@Suppress("ClassName")
class Vehicle_CarsBrandFragment : Fragment(R.layout.fragment_vehicle_cars_brand) {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setupCarsBrandRv(rv, resources, requireActivity())
        viewModel.setupVehicleVp2(vp2)

        viewModel.carsBrandRvAdapter.setOnItemClickListener {
            /* here we need to :
            *  TODO : get the {{brand name}} and save in {{bundle}}
            *  TODO : then retrieve this bundle from {{Model fragment}}
            *  thus make a {{Get Request}} from the back end to get all the related models of this car
            *  */
            findNavController().navigate(R.id.action_vehicle_CarsBrandFragment_to_vehicle_Cars_ModelFragment)
        }

    }
}