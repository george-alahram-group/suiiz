package com.suiiz.ui.fragments

import android.app.Activity
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.suiiz.R
import com.suiiz.databinding.FragmentVehicleCarBrandsBinding
import com.suiiz.util.DummyData
import com.suiiz.viewmodels.MainViewModel

@Suppress("ClassName")
class Vehicle_Car_BrandsFragment : Fragment(R.layout.fragment_vehicle_car_brands) {

    private val viewModel: MainViewModel by activityViewModels()
    private var _binding : FragmentVehicleCarBrandsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVehicleCarBrandsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCarsBrandRv(binding.rv, resources, requireActivity())
        // viewModel.setupVehicleVp2(vp2)
        viewModel.setupLoopingVp(binding.loopingVP, requireContext())

        viewModel.carsBrandRvAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putString("brand_id",it.id.toString())
            }
            findNavController().navigate(R.id.to_next_destination,bundle)
        }

    }

    private fun setupCarsBrandRv(rv: RecyclerView, res: Resources, activity: Activity) {
        viewModel.carsBrandRvAdapter.differ.submitList(DummyData.carsBrandList(res))
        rv.apply {
            adapter = viewModel.carsBrandRvAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }
        viewModel.carsBrandRvAdapter.setOnItemClickListener {

        }
    }

}