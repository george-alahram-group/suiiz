package com.suiiz.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.suiiz.R
import com.suiiz.util.Constants.EMAIL
import com.suiiz.util.Constants.NAME
import com.suiiz.util.Constants.PASSWORD
import com.suiiz.util.Constants.SHARED_PREF
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireActivity().getSharedPreferences(SHARED_PREF, 0)
        val editor = sharedPref.edit()
        val email = sharedPref.getString(EMAIL,"")
        val password = sharedPref.getString(PASSWORD,"")

        if (email!=""&&password!="") {
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        }

        requireActivity().onBackPressedDispatcher.addCallback {
            requireActivity().finishAffinity()
        }

        view.apply {
            tvSkip.setOnClickListener { findNavController().navigate(R.id.action_loginFragment_to_mainFragment) }
            btnLogIn.setOnClickListener {
                if (etEmail.text.isNotEmpty()&&etPassWord.text.isNotEmpty()) {
                    editor.apply {
                        putString(EMAIL, etEmail.text.toString())
                        putString(PASSWORD, etPassWord.text.toString())
                        apply()
                    }
                    findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                } else {
                    Snackbar.make(this,resources.getString(R.string.error_message_1),Snackbar.LENGTH_LONG).show()
                }

            }
            tvSignUp.setOnClickListener { findNavController().navigate(R.id.action_loginFragment_to_signUpFragment) }
        }

    }


}