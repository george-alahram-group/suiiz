package com.suiiz.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.suiiz.R
import com.suiiz.adapters.BestSellerAdapter
import com.suiiz.adapters.SelectableBarAdapter
import com.suiiz.adapters.WantedStoreAdapter
import com.suiiz.adapters.model_parts.ModelPartsAdapter
import com.suiiz.databinding.FragmentVehicleModelPartsBinding
import com.suiiz.util.DummyData
import com.suiiz.viewmodels.MainViewModel

@Suppress("ClassName")
class Vehicle_Model_PartsFragment:Fragment(R.layout.fragment_vehicle_model_parts) {

    private var _binding : FragmentVehicleModelPartsBinding? = null
    private val binding get() = _binding!!
    companion object const private val TAG = "Vehicle_Model_PartsFragment"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentVehicleModelPartsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() {

        binding.apply {
            viewModel.setupLoopingVp(loopingVP,requireContext())
        }

        binding.apply {
            val filter1Adapter = SelectableBarAdapter()
            filter1Adapter.differ.submitList(mutableListOf("ENGINE","ACCESSORIES","SERVICE","Engine","ACCESSORIES"))
            rvFilter1.adapter = filter1Adapter
            filter1Adapter.setOnItemClickListener {
                Log.d(TAG, it)
            }
        }

        binding.apply {
            val filter2Adapter = SelectableBarAdapter()
            filter2Adapter.differ.submitList(mutableListOf("INTERNAL","EXTERNAL"))
            rvFilter2.adapter = filter2Adapter
            filter2Adapter.setOnItemClickListener {
                Log.d(TAG, it)
            }
        }

        binding.apply {
            val partsAdapter = ModelPartsAdapter()
            partsAdapter.differ.submitList(DummyData.partsList(resources))
            rvParts.adapter = partsAdapter
            partsAdapter.setOnItemClickListener {
                Log.d(TAG, it.title)
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

    }

}