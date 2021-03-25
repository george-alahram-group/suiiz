package com.suiiz.adapters

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
import com.suiiz.model.Section
import kotlinx.android.synthetic.main.item_service.view.*

class ServiceAdapter : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>(){

    inner class ServiceViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)

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
        ServiceViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_service,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val currentItem = differ.currentList[position]

        holder.itemView.apply {
            Glide.with(this)
                .load(currentItem.image)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .error(R.drawable.ic_image_search)
                .fallback(R.drawable.ic_image_search)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivSectionImg)
            tvTitle.text = currentItem.title
            tvDescription.text = currentItem.description
        }
    }

}