package com.suiiz.adapters.vehicle_fragment_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.suiiz.R
import com.suiiz.databinding.ItemServiceBinding
import com.suiiz.model.Section

class VehiclesRecyclerAdapter : RecyclerView.Adapter<VehiclesRecyclerAdapter.VehicleViewHolder>(){

    inner class VehicleViewHolder(val binding:ItemServiceBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffUtil  = object : DiffUtil.ItemCallback<Section>() {
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
            ItemServiceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val currentItem = differ.currentList[position]

        holder.binding.apply {
            Glide.with(root)
                .load(currentItem.image)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .error(R.drawable.ic_image_search)
                .fallback(R.drawable.ic_image_search)
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                .into(ivSectionImg)
            tvTitle.text = currentItem.title
            tvDescription.text = currentItem.description.toString()

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