package com.zeus.daneeapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {

    fun create(urlBase: String): RickAndMortyServices {
        return Retrofit.Builder()
            .baseUrl(urlBase)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyServices::class.java)
    }
}