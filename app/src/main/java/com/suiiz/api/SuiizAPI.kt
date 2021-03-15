package com.suiiz.api

import com.suiiz.model.VehiclesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SuiizAPI {

    // will be used to define our single request that we can execute from code

    @GET("/vehicle-list")
    suspend fun getVehicleList(
       /* @Query("_page")
        pageNumber: Int = 1*/
    ): Response<VehiclesResponse>

    /*@GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "eg",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apikey")
        apiKey: String = API_KEY
    ): Response<VehiclesResponse>*/

}