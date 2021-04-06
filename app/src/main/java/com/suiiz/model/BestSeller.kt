package com.suiiz.model

data class BestSeller(
    val id: Int,
    val sellerName: String,
    val partName: String,
    val image: String,
    val category: String,
    val price: Float,
    val rate: Float,
    val discount: Int
)
