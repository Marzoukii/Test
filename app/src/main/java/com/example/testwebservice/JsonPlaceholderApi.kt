package com.example.testwebservice

import com.example.testwebservice.Model.Cat
import com.example.testwebservice.Model.Post
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory


import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET("/posts")
    fun getPosts(): Deferred<Response<List<Post>>>
    @GET("/api/catGeneric/all")
    fun getCats(): Deferred<Response<List<Cat>>>

    companion object {
        private const val BASE_URL = "http://207.180.211.159:9090"
        fun getApi(): JsonPlaceholderApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(JsonPlaceholderApi::class.java)
    }
}
