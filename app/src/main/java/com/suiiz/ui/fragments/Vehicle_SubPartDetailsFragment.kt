package com.suiiz.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.suiiz.R
import com.suiiz.adapters.BestSellerAdapter
import com.suiiz.adapters.WantedStoreAdapter
import com.suiiz.adapters.sub_parts_details.ProductDetailsRvAdapter
import com.suiiz.adapters.sub_parts_details.ProductDetailsVp2Adapter
import com.suiiz.databinding.FragmentVehicleSubPartDetailsBinding
import com.suiiz.util.DummyData

@Suppress("ClassName")
class Vehicle_SubPartDetailsFragment : Fragment(R.layout.fragment_vehicle_sub_part_details) {

    private var _binding :FragmentVehicleSubPartDetailsBinding? = null
    private val binding get() = _binding!!
    companion object const private val TAG = "Vehicle_SubPartDetailsFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVehicleSubPartDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() {
        // logic here

        // TODO: ViewPager implementation
        // TODO: Recycler view implementation

        binding.apply {
            // favorite may be true when we will get the API response for this page
            var isFavorited = false
            btnFavorite.setOnClickListener {
                isFavorited = if (isFavorited) {
                    btnFavorite.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.ic_favorite_off))
                    false
                } else {
                    btnFavorite.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.ic_favorite))
                    true
                }
            }

        }

        binding.includeFooter.apply {
            val bestSellerAdapter = BestSellerAdapter()
            bestSellerAdapter.differ.submitList(DummyData.bestSellerList(resources))
            rvBestSeller.adapter = bestSellerAdapter
            bestSellerAdapter.setOnItemClickListener {
                Log.d(TAG, it.id.toString())
            }
        }

        binding.includeFooter.apply {
            val wantedStoreAdapter = WantedStoreAdapter()
            wantedStoreAdapter.differ.submitList(DummyData.wantedStoresList())
            rvWantedStores.adapter = wantedStoreAdapter
            wantedStoreAdapter.setOnItemClickListener {
                Log.d(TAG, it)
            }
        }

        binding.apply {
            val vp2Adapter = ProductDetailsVp2Adapter()
            vp2Adapter.differ.submitList(DummyData.productDetailsImagesList())
            vp2ProductImages.adapter = vp2Adapter
            val rvAdapter = ProductDetailsRvAdapter()
            rvAdapter.differ.submitList(DummyData.productDetailsImagesList())
            rvProductImages.adapter = rvAdapter

        }

    }

}