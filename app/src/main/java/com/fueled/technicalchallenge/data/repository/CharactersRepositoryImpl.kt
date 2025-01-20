package com.fueled.technicalchallenge.data.repository

import com.fueled.technicalchallenge.data.network.model.CharacterResponseDTO
import com.fueled.technicalchallenge.data.network.service.CharactersApi
import com.fueled.technicalchallenge.domain.repository.CharactersRepository
import com.fueled.technicalchallenge.utils.DispatcherProvider
import com.fueled.technicalchallenge.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

class CharactersRepositoryImpl(
    private val charactersApi: CharactersApi,
    private val dispatcherProvider: DispatcherProvider
): CharactersRepository {

    override suspend fun getCharacters(): Flow<NetworkResult<CharacterResponseDTO>> {
        TODO("Not yet implemented")
    }
}