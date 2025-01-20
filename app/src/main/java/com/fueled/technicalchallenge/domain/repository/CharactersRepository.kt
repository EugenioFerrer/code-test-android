package com.fueled.technicalchallenge.domain.repository

import com.fueled.technicalchallenge.data.network.model.CharacterResponseDTO
import com.fueled.technicalchallenge.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    suspend fun getCharacters(): Flow<NetworkResult<CharacterResponseDTO>>
}