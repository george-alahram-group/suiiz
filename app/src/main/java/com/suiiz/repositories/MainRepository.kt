package com.suiiz.repositories

import android.content.res.Resources
import com.suiiz.api.RetrofitInstance
import com.suiiz.util.DummyData

class MainRepository(
    /* val db : data base calss */
) {

    suspend fun getVehicleList(/*pageNumber: Int*/) = RetrofitInstance.api.getVehicleList(/*pageNumber*/)

}