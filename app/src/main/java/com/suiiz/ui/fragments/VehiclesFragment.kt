package com.suiiz.ui.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.suiiz.R
import com.suiiz.util.Constants.QUERY_PAGE_SIZE
import com.suiiz.util.DummyData
import com.suiiz.util.Resource
import com.suiiz.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_vehicles.*

class VehiclesFragment : Fragment(R.layout.fragment_vehicles) {

    private val viewModel: MainViewModel by activityViewModels()

    var isLoading = false
    var isLastPage = false
    var isScrolling = false

    @SuppressLint("ShowToast")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupVehicleRv(rv, requireActivity())
        setupVehicleVp2(vp2)

        viewModel.vehiclesRecyclerAdapter.setOnItemClickListener {
            when(it.id){
                0 -> findNavController().navigate(R.id.action_vehiclesFragment_to_vehicle_CarsBrandFragment)
            }
        }

        viewModel.vehicles.observe(viewLifecycleOwner, Observer { response ->
            when(response) {
                is Resource.Success -> {
                    hideProgressView()
                    response.data?.let {
                        viewModel.vehiclesRecyclerAdapter.differ.submitList(it.list.toList())
                        val totalPages = it.result / QUERY_PAGE_SIZE + 2
                        isLastPage = viewModel.vehiclesPage == totalPages
                        if (isLastPage) {
                            // rv.setPadding(0,0,0,0)
                        }
                    }
                }
                is Resource.Error -> {
                    hideProgressView()
                    response.message?.let { message ->
                        Snackbar.make(view,"An Error Occurred: $message",Snackbar.LENGTH_LONG)
                            .setAnchorView(fabService)
                            .show()
                    }
                }
                is Resource.Loading -> {
                    showProgressView()
                }
            }
        })

    }

    private fun hideProgressView() {
        animationView.visibility = View.INVISIBLE
        isLoading = false
    }

    private fun showProgressView() {
        animationView.visibility = View.VISIBLE
        isLastPage = true
    }

    private val scrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount

            val isNotLoadingAndNotLastPage = !isLoading && !isLastPage
            val isAtLastItem = firstVisibleItemPosition + visibleItemCount >= totalItemCount
            val isNotAtTheBeginning = firstVisibleItemPosition >= 0
            val isTotalMoreThanVisible = totalItemCount>= QUERY_PAGE_SIZE

            val shouldPaginate = isNotLoadingAndNotLastPage && isAtLastItem && isNotAtTheBeginning && isTotalMoreThanVisible && isScrolling

            if (shouldPaginate) {
                viewModel.getVehicleList()
                isScrolling = false
            }

        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                isScrolling = true
            }
        }
    }

    private fun setupVehicleRv(rv: RecyclerView, activity: Activity) {
        // vehiclesRecyclerAdapter.differ.submitList(DummyData.vehicleList(res))
        rv.apply {
            adapter = viewModel.vehiclesRecyclerAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(scrollListener)
        }
    }

    private fun setupVehicleVp2(vp2: ViewPager2) {
        viewModel.vehiclesVp2Adapter.differ.submitList(DummyData.vp2List())
        vp2.apply {
            adapter = viewModel.vehiclesVp2Adapter
        }
    }

}