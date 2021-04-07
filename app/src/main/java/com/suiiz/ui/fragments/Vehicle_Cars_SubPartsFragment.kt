package com.suiiz.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.suiiz.R
import com.suiiz.adapters.SelectableBarAdapter
import com.suiiz.adapters.SubPartsAdapter
import com.suiiz.databinding.FragmentVehicleCarsSubPartsBinding
import com.suiiz.model.SelectableItem
import com.suiiz.util.DummyData

@Suppress("ClassName")
class Vehicle_Cars_SubPartsFragment : Fragment(R.layout.fragment_vehicle_cars_sub_parts) {

    private var _binding: FragmentVehicleCarsSubPartsBinding? = null
    private val binding get() = _binding!!

    companion object const

    private val TAG = "Vehicle_Cars_SubPartsFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVehicleCarsSubPartsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selListener()
    }

    private fun selListener() {
        // logic here
        binding.apply {
            val filter1Adapter = SelectableBarAdapter()
            filter1Adapter.differ.submitList(
                mutableListOf(
                    SelectableItem("ENGINE", false),
                    SelectableItem("ACCESSORIES", true),
                    SelectableItem("SERVICE", false),
                    SelectableItem("ENGINE", false),
                    SelectableItem("ACCESSORIES", false)
                )
            )
            rvFilter1.adapter = filter1Adapter
            filter1Adapter.setOnItemClickListener {
                Log.d(TAG, it.title)
            }
        }

        binding.apply {
            val filter2Adapter = SelectableBarAdapter()
            filter2Adapter.differ.submitList(
                mutableListOf(
                    SelectableItem("ENGINE", false),
                    SelectableItem("ACCESSORIES", true),
                    SelectableItem("SERVICE", false),
                    SelectableItem("ENGINE", false),
                    SelectableItem("ACCESSORIES", false),
                )
            )
            rvFilter2.adapter = filter2Adapter
            filter2Adapter.setOnItemClickListener {
                Log.d(TAG, it.title)
            }
        }

        binding.apply {
            val partsAdapter = SubPartsAdapter()
            partsAdapter.differ.submitList(DummyData.partsDetailedList())
            rv.adapter = partsAdapter
            partsAdapter.setOnItemClickListener {
                Log.d(TAG, it.id.toString())
                findNavController().navigate(R.id.to_next_destination)
            }
        }


    }

}