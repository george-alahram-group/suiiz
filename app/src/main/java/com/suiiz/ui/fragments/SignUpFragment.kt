package com.suiiz.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.suiiz.R
import com.suiiz.util.Countries
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.spCountry

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arr = resources.getStringArray(R.array.countries)
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, arr)
        spCountry.adapter = adapter

        spCountry.setPopupBackgroundResource(R.color.primaryColor)

        getCountryCode(spCountry, tvCountryCode)

        tvSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        tvSkip.setOnClickListener {
            /*findNavController().navigate(TODO("navigate to Home"))*/
        }
    }

    fun getCountryCode(sp: Spinner, tv: TextView) {
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tv.text = Countries.code[position + 1]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

}