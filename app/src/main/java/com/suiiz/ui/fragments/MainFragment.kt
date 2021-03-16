package com.suiiz.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.suiiz.R
import com.suiiz.util.Constants.EMAIL
import com.suiiz.util.Constants.PASSWORD
import com.suiiz.util.Constants.SHARED_PREF
import eightbitlab.com.blurview.BlurView
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.bottom_app_bar_blur.*
import kotlinx.android.synthetic.main.bottom_app_bar_blur.view.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // blurBackground(blurViewMain, 5f)
        blurBackground(blurView, 20f)

        val sharedPref = requireActivity().getSharedPreferences(SHARED_PREF, 0)
        val email = sharedPref.getString(EMAIL, "")
        val password = sharedPref.getString(PASSWORD, "")

        Log.i(SHARED_PREF, email.toString())
        Log.i(SHARED_PREF, password.toString())

        bottomAppBar.fabAdd.setOnClickListener {



            nav_host_fragment_container.findNavController().apply {
                when (currentDestination?.id) {
                    R.id.homeFragment -> navigate(R.id.action_homeFragment_to_addAdFragment)
                    R.id.servicesFragment -> navigate(R.id.action_servicesFragment_to_addAdFragment)
                    R.id.vehiclesFragment -> navigate(R.id.action_vehiclesFragment_to_addAdFragment)
                    R.id.vehicle_CarsBrandFragment -> navigate(R.id.action_vehicle_CarsBrandFragment_to_addAdFragment)
                    R.id.vehicle_Cars_ModelFragment -> navigate(R.id.action_vehicle_Cars_ModelFragment_to_addAdFragment)
                }
            }



        }

    }

    private fun blurBackground(blurView: BlurView, radius: Float) {

        val decorView = requireActivity().window.decorView
        val rootView = mainContainer
        val windowBackground = decorView.background
        blurView.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(requireActivity().baseContext))
            .setBlurRadius(radius)
            .setHasFixedTransformationMatrix(true)

    }

}