package com.fueled.technicalchallenge.data.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponseDTO(
    @SerialName("attributionHTML")
    val attributionHTML: String,
    @SerialName("attributionText")
    val attributionText: String,
    @SerialName("code")
    val code: String,
    @SerialName("copyright")
    val copyright: String,
    @SerialName("data")
    val `data`: Data,
    @SerialName("etag")
    val etag: String,
    @SerialName("status")
    val status: String
)