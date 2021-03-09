package com.suiiz.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitInstance {

    companion object {

        private val retrofit by lazy {

            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val clint = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            // TODO("get from constant and put it to gitignore")
            Retrofit.Builder()
                .baseUrl("/**/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(clint)
                .build()

        }

        val api : SuiizAPI by lazy {
            retrofit.create()
        }

    }
}