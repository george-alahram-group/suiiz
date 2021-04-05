package com.suiiz.model

data class Favorite(
    val id: Int,
    val title: String,
    val description: String,
    val rate: Float,
    val price: String,
    val priceBefore: String,
    val isFavorite: Boolean,
    val image: String,
    val videoURL: String,
    val location: String,
    val adOwner: String,
    val favoriteDate: String
)
