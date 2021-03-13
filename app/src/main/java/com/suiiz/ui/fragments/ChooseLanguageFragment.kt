package com.suiiz.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.suiiz.R
import com.suiiz.util.Constants
import com.suiiz.util.Constants.SHARED_PREF
import com.suiiz.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_choose_language.*

class ChooseLanguageFragment : Fragment(R.layout.fragment_choose_language) {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         val sharedPref = requireActivity().getSharedPreferences(SHARED_PREF,0)
         val lang = sharedPref.getString(Constants.LANG,"")
         val name = sharedPref.getString(Constants.NAME,"")
         val email = sharedPref.getString(Constants.EMAIL,"")
         val password = sharedPref.getString(Constants.PASSWORD,"")
        if (lang != "") {
            findNavController().navigate(R.id.action_chooseLanguageFragment_to_loginFragment)
        }
        super.onViewCreated(view, savedInstanceState)

        viewModel.setupCountrySpinner(spCountry, requireContext(), resources)

        btnArabic.setOnClickListener {
            viewModel.setLanguageCode("ar", requireActivity())
            route(name!!,email!!,password!!)
        }
        btnEnglish.setOnClickListener {
            viewModel.setLanguageCode("en", requireActivity())
            route(name!!,email!!,password!!)
        }


    }

    private fun route(name:String, email:String, password:String) {
        viewModel.setLanguageCode("ar", requireActivity())
        if ((name == "") || (email == "")) {
            findNavController().navigate(R.id.action_chooseLanguageFragment_to_signUpFragment)
        } else if ((name != "" && email != "") && (password == "")) {
            findNavController().navigate(R.id.action_chooseLanguageFragment_to_loginFragment)
        } else if (name != "" && email != "" && password != ""){
            findNavController().navigate(R.id.action_chooseLanguageFragment_to_mainFragment)
        }
    }

}