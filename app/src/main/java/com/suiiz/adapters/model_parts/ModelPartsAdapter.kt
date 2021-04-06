package com.suiiz.adapters.model_parts

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
import com.suiiz.databinding.ItemVehiclesPartBinding
import com.suiiz.model.Part
import com.suiiz.model.Section
import kotlinx.android.synthetic.main.item_home_category.view.*
import kotlinx.android.synthetic.main.item_vehicles_brand.view.*

class ModelPartsAdapter : RecyclerView.Adapter<ModelPartsAdapter.CardsBrandViewHolder>() {

    inner class CardsBrandViewHolder(val binding:ItemVehiclesPartBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffUtil = object : DiffUtil.ItemCallback<Part>() {
        override fun areItemsTheSame(oldItem: Part, newItem: Part): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Part, newItem: Part): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val differ = AsyncListDiffer(this, diffUtil)

    override fun getItemCount() = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CardsBrandViewHolder(
            ItemVehiclesPartBinding.inflate(
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
                .into(ivImage)
            tvTitle.text = current.title

            view.setOnClickListener {
                onItemClickListener?.let {
                    it(current)
                }
            }
        }

    }

    private var onItemClickListener: ((Part) -> Unit)? = null

    fun setOnItemClickListener(listener: (Part) -> Unit) {
        onItemClickListener = listener
    }

}