package com.suiiz.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.suiiz.R
import com.suiiz.ui.fragments.AddAdsCompany
import com.suiiz.ui.fragments.AddAdsPersonal
import kotlinx.android.synthetic.main.item_add_ads_vp2.*
import kotlinx.android.synthetic.main.item_add_ads_vp2.view.*

class AddAdsVpAdapter : RecyclerView.Adapter<AddAdsVpAdapter.AddAdsViewHolder>() {

    private val list = listOf(
        AddAdsCompany(),
        AddAdsPersonal()
    )

    inner class AddAdsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AddAdsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_add_ads_vp2,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: AddAdsViewHolder, position: Int) {
        val currentItem = list[position]

        holder.itemView.apply {



        }

    }

}