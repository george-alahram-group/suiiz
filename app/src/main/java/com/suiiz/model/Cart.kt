package com.suiiz.model

data class Cart(
    val id: Int,
    val title: String,
    val image: String,
    val partType: String,
    val price: Int,
    val owner: String,
    var count: Int = 1
)
