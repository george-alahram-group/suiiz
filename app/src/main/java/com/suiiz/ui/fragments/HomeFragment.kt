package com.suiiz.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.suiiz.R
import com.suiiz.adapters.HomeAdapter
import com.suiiz.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var homeAdapter: HomeAdapter
    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeAdapter = viewModel.homeAdapter
        viewModel.setupHomeRv(rv, resources, requireActivity())

        fabService.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_servicesFragment) }

        homeAdapter.setOnItemClickListener {
            when (it.id) {
                0 -> findNavController().navigate(R.id.action_homeFragment_to_vehiclesFragment)
                1 -> { }
                2 -> { }
                3 -> { }
                4 -> { }
                5 -> { }
            }
        }

    }


}