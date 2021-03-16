package com.suiiz.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asksira.loopingviewpager.LoopingPagerAdapter
import com.bumptech.glide.Glide
import com.suiiz.R
import kotlinx.android.synthetic.main.item_ads_loop_vp.view.*

class AdsLoopViewPagerAdapter(
    context: Context,
    itemList: ArrayList<String>,
    isInfinite: Boolean
) : LoopingPagerAdapter<String>(context, itemList, isInfinite) {

    override fun inflateView(viewType: Int, container: ViewGroup, listPosition: Int) =
        LayoutInflater.from(context).inflate(R.layout.item_ads_loop_vp, container, false)!!

    override fun bindView(convertView: View, listPosition: Int, viewType: Int) {
        Glide.with(context).load(itemList?.get(listPosition)).into(convertView.ivImg)
    }

}