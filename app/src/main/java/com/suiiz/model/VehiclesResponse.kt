package com.suiiz.model

data class VehiclesResponse(
    val list: MutableList<VehicleList>,
    val result: Int,
    val status: String
)