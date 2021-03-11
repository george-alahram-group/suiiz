package com.suiiz.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.suiiz.R
import com.suiiz.adapters.ServiceAdapter
import com.suiiz.util.DumyData
import kotlinx.android.synthetic.main.fragment_services.*

class ServicesFragment : Fragment(R.layout.fragment_services) {

    private lateinit var serviceAdapter :ServiceAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        serviceAdapter = ServiceAdapter()
        setupRecyclerView(rv)

    }

    private fun setupRecyclerView(rv: RecyclerView){
        serviceAdapter = ServiceAdapter()
        serviceAdapter.differ.submitList(DumyData.servicesList)
        rv.apply {
            adapter = serviceAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}