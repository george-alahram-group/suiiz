package com.suiiz.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.suiiz.R
import com.suiiz.adapters.cart_fragment_adpters.MyCartAdapter
import com.suiiz.databinding.FragmentMyCartBinding
import com.suiiz.util.DummyData

class MyCartFragment:Fragment(R.layout.fragment_my_cart) {

    private var _binding : FragmentMyCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMyCartBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private lateinit var cartAdapter : MyCartAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener(){
        cartAdapter = MyCartAdapter(requireContext())
        cartAdapter.differ.submitList(DummyData.cartList(resources))
        binding.rvCart.adapter = cartAdapter
    }

}