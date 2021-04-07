package com.suiiz.model

data class SubPart(
    val id: Int,
    val title: String,
    val image: String,
    val publisher: String,
    val price: Float,
    val priceBeforeDiscount: Float,
    val location: String,
    val countryFlag: String,
    val publishedAt: String,
    val rate: Float,
    val videoUrl: String,
    var isFavorited: Boolean
)