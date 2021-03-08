package com.suiiz.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
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
        homeAdapter.differ
        homeAdapter.differ.submitList(DumyData._list1)

        setupRecyclerView(rv)

    }

    private fun setupRecyclerView(rv: RecyclerView){
        homeAdapter = HomeAdapter()
        rv.apply {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}