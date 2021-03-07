package com.example.suiiz.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.suiiz.R
import kotlinx.android.synthetic.main.fragment_choose_language.*

class ChooseLanguageFragment() : Fragment(R.layout.fragment_choose_language) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arr = resources.getStringArray(R.array.countries)
        val adapter = ArrayAdapter(requireContext(),R.layout.spinner_item,arr)
        spCountry.adapter = adapter

        btnArabic.setOnClickListener {
            findNavController().navigate(R.id.action_chooseLanguageFragment_to_loginFragment)
        }
        btnEnglish.setOnClickListener {
            findNavController().navigate(R.id.action_chooseLanguageFragment_to_loginFragment)
        }

        spCountry.setPopupBackgroundResource(R.color.primaryColor)

    }



}