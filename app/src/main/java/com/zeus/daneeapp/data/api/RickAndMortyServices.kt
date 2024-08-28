package com.zeus.daneeapp.data.api

import com.zeus.daneeapp.data.models.ApiResponse
import retrofit2.http.GET

interface RickAndMortyServices {

    @GET("character")
    suspend fun getCharacters(): ApiResponse

}