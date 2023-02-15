package com.example.progica_android.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL ="https://progica.localhost/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface GiteApiService{
    @GET("gites")
    suspend fun getGites():List<Gite>
}


object GiteApi{
    val retrofitService : GiteApiService by lazy {
        retrofit.create(GiteApiService::class.java)
    }
}