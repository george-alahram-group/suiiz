package com.example.suiiz.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.suiiz.R
import com.example.suiiz.util.Countries
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArrayAdapter(requireContext(),R.layout.spinner_item,Countries.country)
        spCountry.adapter = adapter

        getCountryCode(spCountry,tvCountryCode)

        tvSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        tvSkip.setOnClickListener {
            /*findNavController().navigate(TODO("navigate to Home"))*/
        }
    }

    fun getCountryCode(sp: Spinner,tv:TextView) {
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tv.text = Countries.code[position+1]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

}