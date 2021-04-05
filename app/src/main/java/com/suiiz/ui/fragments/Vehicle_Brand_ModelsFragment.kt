package com.suiiz.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.suiiz.R
import com.suiiz.adapters.cars_model_adapters.BrandModelsAdapter
import com.suiiz.databinding.FragmentVehicleBrandModelsBinding
import com.suiiz.util.DummyData
import com.suiiz.viewmodels.MainViewModel

@Suppress("ClassName")
class Vehicle_Brand_ModelsFragment : Fragment(R.layout.fragment_vehicle_brand_models) {

    private var _binding: FragmentVehicleBrandModelsBinding? = null
    private val binding get() = _binding!!
    private val TAG = "Vehicle_Brand_ModelsFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVehicleBrandModelsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private val viewModel: MainViewModel by activityViewModels()
    val args: Vehicle_Car_BrandsFragmentArgs by navArgs()
    private lateinit var brandModelAdapter: BrandModelsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() {
        Log.d(TAG, args.brandId.toString())

        // logic here
        brandModelAdapter = BrandModelsAdapter(requireContext())

        viewModel.setupLoopingVp(binding.loopingVP, requireContext())

        brandModelAdapter.differ.submitList(DummyData.modelsList(resources))
        binding.rv.adapter =  brandModelAdapter
        brandModelAdapter.setOnItemClickListener {

        }
    }



}