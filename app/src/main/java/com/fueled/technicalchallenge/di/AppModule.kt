package com.fueled.technicalchallenge.di

import com.fueled.technicalchallenge.data.ApiConstants
import com.fueled.technicalchallenge.data.network.service.CharactersApi
import com.fueled.technicalchallenge.data.UnWrapperFactory
import com.fueled.technicalchallenge.data.local.MarvelDatabase
import com.fueled.technicalchallenge.data.local.dao.CharacterDao
import com.fueled.technicalchallenge.presentation.character_list.CharacterListViewModel
import com.fueled.technicalchallenge.utils.DefaultDispatcherProvider
import com.fueled.technicalchallenge.utils.DispatcherProvider
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.squareup.moshi.Moshi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object AppModule {
    private val moshi = Moshi.Builder()
        .build()
    private val moshiConverterFactory = MoshiConverterFactory.create(moshi)

    private val charactersApi = Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(UnWrapperFactory)
        .addConverterFactory(moshiConverterFactory)
        .build()
        .create(CharactersApi::class.java)

    val characterListViewModel = CharacterListViewModel(charactersApi)
}

val appModule = module {

    single<OkHttpClient> {
        OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS).retryOnConnectionFailure(true).build()
    }

    single<Retrofit> {
        val contentType = "application/json".toMediaType()

        Retrofit.Builder().baseUrl(ApiConstants.BASE_URL).client(get())
            .addConverterFactory(Json.asConverterFactory(contentType)).build()
    }

    single<CharactersApi> {
        val retrofit = get<Retrofit>()
        retrofit.create()
    }

    single<DispatcherProvider> {
        DefaultDispatcherProvider()
    }

    single<MarvelDatabase> {
        MarvelDatabase.getDatabase(get())
    }

    single<CharacterDao> {
        val marvelDatabase = get<MarvelDatabase>()
        marvelDatabase.characterDao()
    }

}
