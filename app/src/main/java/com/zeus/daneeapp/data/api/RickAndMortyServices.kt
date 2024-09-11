package com.zeus.daneeapp.data.api

import com.zeus.daneeapp.data.models.ApiResponse
import com.zeus.daneeapp.data.models.CharacterDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyServices {

    @GET("character")
    suspend fun getCharacters(): ApiResponse

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: String): CharacterDTO?
}