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
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter() : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Section>() {
        override fun areItemsTheSame(oldItem: Section, newItem: Section): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Section, newItem: Section): Boolean {
            return oldItem.title == newItem.title
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_home,
                parent,
                false
            )
        )

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
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
