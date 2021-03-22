package com.suiiz.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import com.google.android.material.tabs.TabLayout
import com.suiiz.R
import com.suiiz.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_add_ad.*

class AddAdFragment : Fragment(R.layout.fragment_add_ad) {

    val viewModel : MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position) {
                    0 -> {
                        includePersonal.visibility = View.GONE
                        includeCompany.visibility = View.VISIBLE
                    }
                    1 -> {
                        includeCompany.visibility = View.GONE
                        includePersonal.visibility = View.VISIBLE
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

    }

}