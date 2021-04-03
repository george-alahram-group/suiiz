package com.suiiz.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.suiiz.R
import com.suiiz.databinding.FragmentMainBinding
import com.suiiz.util.Constants.SHARED_PREF
import eightbitlab.com.blurview.BlurView
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.item_home.view.*
import kotlinx.android.synthetic.main.item_home.view.view
import kotlinx.android.synthetic.main.item_vehicles_brand.view.*
import kotlinx.android.synthetic.main.top_app_bar.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // declarations
        val sharedPref = requireActivity().getSharedPreferences(SHARED_PREF, 0)
        blurBackground(binding.blurView, 20f)

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

    private fun setListener() {
        binding.bottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                when (newIndex) {
                    0 -> binding.navHostFragment.findNavController().navigate(R.id.home_destination)
                    1 -> binding.navHostFragment.findNavController().navigate(R.id.profile_destination)
                    2 -> binding.navHostFragment.findNavController().navigate(R.id.addAd_destination)
                    3 -> binding.navHostFragment.findNavController().navigate(R.id.favorite_destination)
                    4 -> binding.navHostFragment.findNavController().navigate(R.id.chat_destination)
                }
            }
        })
        binding.upperBar.apply {
            var num = 1 ;
            ivSearch.setOnClickListener {
                when (num) {
                    1 -> {
                        binding.navHostFragment.findNavController().navigate(R.id.search_destination)
                        GlobalScope.launch(Dispatchers.Main) { prepareToolbarForSearching() }
                        num = 2;
                    }
                    2 -> { /* doSearch() */ }
                }
            }
            ivBack.setOnClickListener{
                binding.navHostFragment.findNavController().navigate(R.id.home_destination)
                GlobalScope.launch (Dispatchers.Main){ changeSearchState() }
                num = 1 ;
            }

        }
    }


    private suspend fun prepareToolbarForSearching() {

        binding.upperBar.apply {
            animateToGone(listOf(ivCall, ivLogo, includeCarts.root))
            animateToShow(listOf(etSearch, ivBack))
        }
    }

    private suspend fun changeSearchState() {
        binding.upperBar.apply {
            animateToGone(listOf(etSearch, ivBack))
            animateToShow(listOf(ivCall, ivLogo, includeCarts.root))
        }
    }


    private suspend fun animateToGone(views : List<View>) {
        for (i in views) {
            i.animate().alpha(0f).scaleX(0f).setDuration(200).start()
        }
        delay(200)
        for (i in views) {
            i.visibility = View.GONE
        }
    }

    private suspend fun animateToShow(views : List<View>) {
        delay(200)
        for (i in views) {
            i.visibility = View.VISIBLE
            i.animate().alpha(1f).scaleX(1f).setDuration(200).start()
        }
    }


}