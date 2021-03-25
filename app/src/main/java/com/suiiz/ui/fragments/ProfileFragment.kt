package com.suiiz.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.suiiz.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment:Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // declarations

        // actions
        setListener()

    }

    private fun setListener(){

        cvMyCart.setOnClickListener {
            findNavController().navigate(R.id.to_next_destination)
        }

    }

}