package com.suiiz.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.suiiz.R
import com.suiiz.adapters.vehicleFragmnetAdapters.VehiclesRecyclerAdapter
import com.suiiz.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_vehicles.*

class VehiclesFragment : Fragment(R.layout.fragment_vehicles) {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var rvAdapter : VehiclesRecyclerAdapter

    var isLoading = false
    var isLastPage = false
    var isScrolling = false

    @SuppressLint("ShowToast")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvAdapter = VehiclesRecyclerAdapter()
        // setupPhotosRv(rv, requireActivity())
        viewModel.setupLoopingVp(loopingVP, requireContext())

       /* viewModel.photos.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressView()
                    response.data?.let {
                        viewModel.photosAdapter.differ.submitList(it.list.toList())
                        val totalPages = it.list.size / QUERY_PAGE_SIZE + 2
                        isLastPage = viewModel.photosPage == totalPages
                        if (isLastPage) {
                            rv.setPadding(0,0,0,0)
                        }
                    }
                }
                is Resource.Error -> {
                    hideProgressView()
                    response.message?.let { message ->
                        Snackbar.make(view, "An Error Occurred: $message", Snackbar.LENGTH_LONG)
                            .setAnchorView(fabService)
                            .show()
                    }
                }
                is Resource.Loading -> {
                    showProgressView()
                }
            }
        })*/

    }

    private fun hideProgressView() {
        animationView.visibility = View.INVISIBLE
        isLoading = false
    }

    private fun showProgressView() {
        animationView.visibility = View.VISIBLE
        isLastPage = true
    }

/*
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
            val isTotalMoreThanVisible = totalItemCount >= QUERY_PAGE_SIZE
            val shouldPaginate = isNotLoadingAndNotLastPage && isAtLastItem && isNotAtTheBeginning &&
                    isTotalMoreThanVisible && isScrolling

            if (shouldPaginate) {
                Log.d(Constants.TAG," shouldPaginate ")
                viewModel.getPhotos()
                isScrolling = false
            }

        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                Log.d(Constants.TAG," scrolling now ")
                isScrolling = true
            }
        }
    }
*/

/*
    private fun setupPhotosRv(rv: RecyclerView, activity: Activity) {
        rv.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(scrollListener)
        }
    }
*/


}