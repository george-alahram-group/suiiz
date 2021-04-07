package com.suiiz.adapters.sub_parts_details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.suiiz.R
import com.suiiz.databinding.ItemProductDetailesBinding

class ProductDetailsVp2Adapter : RecyclerView.Adapter<ProductDetailsVp2Adapter.CardsBrandViewHolder>() {

    companion object const private val TAG = "SubPartDetailsVp2Adapter"

    inner class CardsBrandViewHolder(val binding:ItemProductDetailesBinding) : RecyclerView.ViewHolder(binding.root)

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
            ItemProductDetailesBinding.inflate(
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
                .into(ivImage)

            root.setOnClickListener {
                onItemClickListener?.let {
                    it(differ.currentList.indexOf(current))
                }
            }

        }

    }

    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }

}