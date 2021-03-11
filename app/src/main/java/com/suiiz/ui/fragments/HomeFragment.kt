package com.suiiz.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.suiiz.R
import com.suiiz.adapters.HomeAdapter
import com.suiiz.util.DumyData
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var homeAdapter : HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeAdapter = HomeAdapter()

        setupRecyclerView(rv)

        fabService.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_servicesFragment) }

        homeAdapter.setOnItemClickListener {
            when(it.id) {
                0 -> findNavController().navigate(R.id.action_homeFragment_to_vehiclesFragment)
                1 -> {}
                2 -> {}
                3 -> {}
                4 -> {}
                5 -> {}
            }
        }

    }

    private fun setupRecyclerView(rv: RecyclerView){
        homeAdapter = HomeAdapter()
        homeAdapter.differ.submitList(DumyData.mainCategoryList)
        rv.apply {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }



}