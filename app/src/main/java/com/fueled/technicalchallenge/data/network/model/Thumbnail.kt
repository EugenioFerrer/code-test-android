package com.fueled.technicalchallenge.data.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Thumbnail(
    @SerialName("extension")
    val extension: String,
    @SerialName("path")
    val path: String
)