package com.suiiz.adapters

import android.util.Log
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
import com.suiiz.model.BestSeller
import com.suiiz.model.Section
import kotlinx.android.synthetic.main.item_home_category.view.*
import kotlinx.android.synthetic.main.item_vehicles_brand.view.*

class BestSellerAdapter : RecyclerView.Adapter<BestSellerAdapter.CardsBrandViewHolder>() {

    companion object const private val TAG = "BestSellerAdapter"

    inner class CardsBrandViewHolder(val binding:ItemVehiclesPartBestSellerBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffUtil = object : DiffUtil.ItemCallback<BestSeller>() {
        override fun areItemsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val differ = AsyncListDiffer(this, diffUtil)

    override fun getItemCount() = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CardsBrandViewHolder(
            ItemVehiclesPartBestSellerBinding.inflate(
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
                .into(ivBestSeller)
            tvBestSellerName.text = current.sellerName
            tvPartName.text = current.partName
            tvCategory.text = current.category
            tvDiscount.text = "-${current.discount} %"
            tvPrice.text = "${current.price} LE"
            rateBar.rating = current.rate

            root.setOnClickListener {
                onItemClickListener?.let {
                    it(current)
                }
            }
        }

    }

    private var onItemClickListener: ((BestSeller) -> Unit)? = null

    fun setOnItemClickListener(listener: (BestSeller) -> Unit) {
        onItemClickListener = listener
    }

}