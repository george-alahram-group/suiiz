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
import com.suiiz.databinding.ItemSelectableBinding
import com.suiiz.databinding.ItemSpinnerBinding
import com.suiiz.databinding.ItemVehiclesPartBestSellerBinding
import com.suiiz.databinding.ItemVehiclesPartWantedStoresBinding
import com.suiiz.model.BestSeller
import com.suiiz.model.Section
import kotlinx.android.synthetic.main.item_home_category.view.*
import kotlinx.android.synthetic.main.item_vehicles_brand.view.*

class WantedStoreAdapter : RecyclerView.Adapter<WantedStoreAdapter.CardsBrandViewHolder>() {

    inner class CardsBrandViewHolder(val binding:ItemVehiclesPartWantedStoresBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffUtil = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.length == newItem.length
        }
    }

    val differ = AsyncListDiffer(this, diffUtil)

    override fun getItemCount() = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CardsBrandViewHolder(
            ItemVehiclesPartWantedStoresBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CardsBrandViewHolder, position: Int) {
        val current = differ.currentList[position]

        holder.binding.apply {
            Glide.with(root)
                .load(current)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .error(R.drawable.ic_image_search)
                .fallback(R.drawable.ic_image_search)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivWantedStore)

            view.setOnClickListener {
                onItemClickListener?.let {
                    it(current)
                }
            }
        }

    }

    private var onItemClickListener: ((String) -> Unit)? = null

    fun setOnItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener
    }

}