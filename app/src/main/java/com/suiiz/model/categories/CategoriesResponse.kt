package com.suiiz.model.categories

data class CategoriesResponse(
    val count: Int,
    val current_page: Int,
    val `data`: List<Data>,
    val error: List<Any>,
    val message: String,
    val status: Boolean
)