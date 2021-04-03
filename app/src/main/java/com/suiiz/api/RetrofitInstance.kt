package com.suiiz.api

import com.suiiz.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class RetrofitInstance {

    companion object {

        private val retrofit by lazy {

            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val clint = OkHttpClient.Builder()
                .connectTimeout(2,TimeUnit.MINUTES)
                .writeTimeout(2,TimeUnit.MINUTES)
                .readTimeout(2,TimeUnit.MINUTES)
                .addInterceptor(logging)
                .build()

            // TODO("get from constant and put it to gitignore")
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(clint)
                .build()

        }

        val api : SuiizAPI by lazy {
            retrofit.create()
        }

    }
}