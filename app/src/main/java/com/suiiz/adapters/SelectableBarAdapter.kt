package com.suiiz.adapters

import android.annotation.SuppressLint
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
import com.suiiz.model.Section
import com.suiiz.model.SelectableItem
import kotlinx.android.synthetic.main.item_vehicles_brand.view.*

class SelectableBarAdapter : RecyclerView.Adapter<SelectableBarAdapter.CardsBrandViewHolder>() {

    inner class CardsBrandViewHolder(val binding:ItemSelectableBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffUtil = object : DiffUtil.ItemCallback<SelectableItem>() {
        override fun areItemsTheSame(oldItem: SelectableItem, newItem: SelectableItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: SelectableItem, newItem: SelectableItem): Boolean {
            return oldItem.isSelected == newItem.isSelected
        }
    }

    val differ = AsyncListDiffer(this, diffUtil)

    override fun getItemCount() = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CardsBrandViewHolder(
            ItemSelectableBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: CardsBrandViewHolder, position: Int) {
        val current = differ.currentList[position]

        holder.binding.apply {
            textView.text = current.title
            if (current.isSelected) {
                /* TODO : change text color &&
                 *  TODO : change container background drawable*/
            } else {
                /* TODO : change text color &&
                *  TODO : change container background drawable*/
            }
        }

        holder.binding.textView.setOnClickListener {
            onItemClickListener?.let {
                it(current)
            }
        }
    }

    private var onItemClickListener: ((SelectableItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (SelectableItem) -> Unit) {
        onItemClickListener = listener
    }

}