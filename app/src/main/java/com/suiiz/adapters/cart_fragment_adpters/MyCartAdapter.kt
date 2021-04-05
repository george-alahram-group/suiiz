package com.suiiz.adapters.cart_fragment_adpters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.suiiz.R
import com.suiiz.databinding.ItemMyCartBinding
import com.suiiz.model.Cart

class MyCartAdapter(val context: Context) : RecyclerView.Adapter<MyCartAdapter.MyCartViewHolder>() {

    inner class MyCartViewHolder(val binding: ItemMyCartBinding):RecyclerView.ViewHolder(binding.root)

    private val diffUtil  = object : DiffUtil.ItemCallback<Cart>() {
        override fun areItemsTheSame(oldItem: Cart, newItem: Cart): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Cart, newItem: Cart): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val differ = AsyncListDiffer(this,diffUtil)

    override fun getItemCount() = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyCartViewHolder(
            ItemMyCartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyCartViewHolder, position: Int) {
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
            tvAdOwner.text = current.owner
            tvPartType.text = current.partType
            tvPrice.text = "${current.price} LE"
            btnPlus.setOnClickListener {
                current.count++
                tvCount.text = current.count.toString()
            }
            btnMinus.setOnClickListener {
                if (current.count > 0) {
                    current.count--
                    tvCount.text = current.count.toString()
                }
            }
        }
    }

    private var onItemClickListener: ((Cart) -> Unit)? = null

    fun setOnItemClickListener(listener: (Cart) -> Unit) {
        onItemClickListener = listener
    }

}