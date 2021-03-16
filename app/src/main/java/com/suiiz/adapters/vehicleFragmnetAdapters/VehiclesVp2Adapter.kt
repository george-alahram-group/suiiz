package com.suiiz.adapters.vehicleFragmnetAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.suiiz.R
import kotlinx.android.synthetic.main.item_ads_loop_vp.view.*

class VehiclesVp2Adapter : RecyclerView.Adapter<VehiclesVp2Adapter.VehicleVp2ViewHolder>(){

    inner class VehicleVp2ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)

    private val diffUtil  = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,diffUtil)

    override fun getItemCount() = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VehicleVp2ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_ads_loop_vp,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: VehicleVp2ViewHolder, position: Int) {
        val currentItem = differ.currentList[position]

        holder.itemView.apply {
            Glide.with(this)
                .load(currentItem)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .error(R.drawable.ic_image_search)
                .fallback(R.drawable.ic_image_search)
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                .into(ivImg)
        }
    }

}