package com.suiiz.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.suiiz.R
import com.suiiz.model.Section
import kotlinx.android.synthetic.main.home_rv_item.view.*

class VehiclesAdapter : RecyclerView.Adapter<VehiclesAdapter.VehicleViewHolder>(){

    inner class VehicleViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)

    val diffUtil  = object : DiffUtil.ItemCallback<Section>() {
        override fun areItemsTheSame(oldItem: Section, newItem: Section): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Section, newItem: Section): Boolean {
            return oldItem.image == newItem.image
        }
    }

    val differ = AsyncListDiffer(this,diffUtil)

    override fun getItemCount() = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VehicleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.service_rv_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val currentItem = differ.currentList[position]

        holder.itemView.apply {
            Glide.with(this).load(currentItem.image).into(ivSectionImg)
            tvTitle.text = currentItem.title
            tvDescription.text = currentItem.description
        }
    }

}