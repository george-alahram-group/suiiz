package com.suiiz.adapters.carsBrandFragmentAdapters

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
import kotlinx.android.synthetic.main.item_vehicles_brand.view.*

class CarsBrandRvAdapter : RecyclerView.Adapter<CarsBrandRvAdapter.CardsBrandViewHolder>() {

    inner class CardsBrandViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffUtil = object : DiffUtil.ItemCallback<Section>() {
        override fun areItemsTheSame(oldItem: Section, newItem: Section): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Section, newItem: Section): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val differ = AsyncListDiffer(this, diffUtil)

    override fun getItemCount() = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CardsBrandViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_vehicles_brand,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CardsBrandViewHolder, position: Int) {
        val currentItem = differ.currentList[position]

        holder.itemView.apply {
            Glide.with(this)
                .load(currentItem.image)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .error(R.drawable.ic_image_search)
                .fallback(R.drawable.ic_image_search)
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                .into(ivBrandImg)
            tvTitle.text = currentItem.title
            tvAdsCount.text = currentItem.description

            view.setOnClickListener {
                onItemClickListener?.let { it(currentItem) }
            }

        }

    }

    private var onItemClickListener: ((Section) -> Unit)? = null

    fun setOnItemClickListener(listener: (Section) -> Unit) {
        onItemClickListener = listener
    }

}