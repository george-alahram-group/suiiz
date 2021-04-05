package com.suiiz.adapters.cars_model_adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.suiiz.R
import com.suiiz.databinding.ItemVehiclesModelBinding
import com.suiiz.model.BrandModel

class BrandModelsAdapter(val context: Context) :RecyclerView.Adapter<BrandModelsAdapter.BrandModelsViewHolder>(){

    inner class BrandModelsViewHolder(val binding: ItemVehiclesModelBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<BrandModel>() {
        override fun areItemsTheSame(oldItem: BrandModel, newItem: BrandModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: BrandModel, newItem: BrandModel): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun getItemCount() = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BrandModelsViewHolder(
            ItemVehiclesModelBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: BrandModelsViewHolder, position: Int) {

        val current = differ.currentList[position]

        holder.binding.apply {

            Glide.with(root)
                .load(current.image)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .error(R.drawable.ic_image_search)
                .fallback(R.drawable.ic_image_search)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivModel)

            tvSeriesCount.text = current.seriesCount.toString()

            val modelArrayAdapter = ArrayAdapter(context,android.R.layout.simple_spinner_item,current.models)
            spModel.adapter = modelArrayAdapter

            val yearArrayAdapter = ArrayAdapter(context,android.R.layout.simple_spinner_item,current.years)
            spYear.adapter = yearArrayAdapter

            ivModel.setOnClickListener {
                onItemClickListener?.let {
                    it(current)
                }
            }

        }

    }

    private var onItemClickListener: ((BrandModel) -> Unit)? = null

    fun setOnItemClickListener(listener: (BrandModel) -> Unit) {
        onItemClickListener = listener
    }

}