package com.suiiz.adapters.favorite_fragment_adapters

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
import com.suiiz.databinding.ItemMyFavoriteBinding
import com.suiiz.model.Favorite

class FavoriteAdapter(val context: Context) : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    inner class FavoriteViewHolder(val binding: ItemMyFavoriteBinding):RecyclerView.ViewHolder(binding.root)

    private val diffUtil  = object : DiffUtil.ItemCallback<Favorite>() {
        override fun areItemsTheSame(oldItem: Favorite, newItem: Favorite): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Favorite, newItem: Favorite): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val differ = AsyncListDiffer(this,diffUtil)

    override fun getItemCount() = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FavoriteViewHolder(
            ItemMyFavoriteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
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
            tvDescription.text = current.description
            tvFavoriteDate.text = "Published At ${current.favoriteDate}"
            tvPrice.text = "${current.price} LE"
            tvPriceBefore.text = "${current.priceBefore} LE"
            tvAdOwner.text = current.adOwner
            rate.rating = current.rate
            if (current.isFavorite) isFavorite.setImageDrawable(context.getDrawable(R.drawable.ic_favorite))
            else isFavorite.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_off))
        }
    }

    private var onItemClickListener: ((Favorite) -> Unit)? = null

    fun setOnItemClickListener(listener: (Favorite) -> Unit) {
        onItemClickListener = listener
    }

}