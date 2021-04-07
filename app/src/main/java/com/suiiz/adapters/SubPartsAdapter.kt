package com.suiiz.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.suiiz.R
import com.suiiz.databinding.ItemVehiclesPartSubItemsBinding
import com.suiiz.model.SubPart

class SubPartsAdapter : RecyclerView.Adapter<SubPartsAdapter.CardsBrandViewHolder>() {

    companion object const private val TAG = "BestSellerAdapter"

    inner class CardsBrandViewHolder(val binding:ItemVehiclesPartSubItemsBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffUtil = object : DiffUtil.ItemCallback<SubPart>() {
        override fun areItemsTheSame(oldItem: SubPart, newItem: SubPart): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: SubPart, newItem: SubPart): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val differ = AsyncListDiffer(this, diffUtil)

    override fun getItemCount() = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CardsBrandViewHolder(
            ItemVehiclesPartSubItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CardsBrandViewHolder, position: Int) {
        val current = differ.currentList[position]

        holder.binding.apply {
            Glide.with(root)
                .load(current.image)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .error(R.drawable.ic_image_search)
                .fallback(R.drawable.ic_image_search)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivPart)
            tvTitle.text = current.title
            tvPublisher.text = current.publisher
            tvPublishedAt.text = current.publishedAt
            tvPrice.text = "${current.price} LE"
            tvPriceBefore.text = "${current.priceBeforeDiscount} LE"
            rateBar.rating = current.rate.dec()
            if (current.isFavorited) ivIsFavorited.setImageDrawable(ContextCompat.getDrawable(root.context,R.drawable.ic_favorite))
            else ivIsFavorited.setImageDrawable(ContextCompat.getDrawable(root.context,R.drawable.ic_favorite_off))

            root.setOnClickListener {
                onItemClickListener?.let {
                    it(current)
                }
            }

            ivIsFavorited.setOnClickListener {
                if (current.isFavorited) {
                    ivIsFavorited.setImageDrawable(ContextCompat.getDrawable(root.context,R.drawable.ic_favorite_off))
                    current.isFavorited = false
                } else {
                    ivIsFavorited.setImageDrawable(ContextCompat.getDrawable(root.context,R.drawable.ic_favorite))
                    current.isFavorited = true
                }
            }
        }

    }

    private var onItemClickListener: ((SubPart) -> Unit)? = null

    fun setOnItemClickListener(listener: (SubPart) -> Unit) {
        onItemClickListener = listener
    }

}