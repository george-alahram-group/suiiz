package com.suiiz.model

data class BrandModel(
    val id: Int,
    val image: String,
    val seriesCount: Int,
    val models: List<String>,
    val years: List<String>
)
