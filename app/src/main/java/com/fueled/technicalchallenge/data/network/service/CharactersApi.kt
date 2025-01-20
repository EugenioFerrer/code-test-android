package com.fueled.technicalchallenge.data.network.service

import com.fueled.technicalchallenge.data.ApiConstants.PUBLIC_KEY
import com.fueled.technicalchallenge.data.model.CharacterApiModel
import com.fueled.technicalchallenge.data.model.PageApiModel
import com.fueled.technicalchallenge.data.network.model.CharacterResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {

    // TODO this stays

    @GET("characters")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("apikey") apiKey: String = PUBLIC_KEY,
        @Query("nameStartsWith") heroNameQuery: String?,
    ): CharacterResponseDTO

}