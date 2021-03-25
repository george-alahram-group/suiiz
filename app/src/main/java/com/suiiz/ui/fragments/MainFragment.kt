package com.suiiz.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.suiiz.R
import com.suiiz.util.Constants.SHARED_PREF
import eightbitlab.com.blurview.BlurView
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.top_app_bar.view.*
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // declarations
        val sharedPref = requireActivity().getSharedPreferences(SHARED_PREF, 0)
        blurBackground(blurView, 20f)

        // actions
        setListener()

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

    private fun setListener () {
        bottom_bar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                when(newIndex) {
                    0 -> navHostFragment.findNavController().navigate(R.id.home_destination)
                    1 -> navHostFragment.findNavController().navigate(R.id.profile_destination)
                    2 -> navHostFragment.findNavController().navigate(R.id.addAd_destination)
                    3 -> navHostFragment.findNavController().navigate(R.id.favorite_destination)
                    4 -> navHostFragment.findNavController().navigate(R.id.chat_destination)
                }
            }
        })
        upperBar.ivSearch.setOnClickListener {
            navHostFragment.findNavController().navigate(R.id.search_destination)
        }
    }


}