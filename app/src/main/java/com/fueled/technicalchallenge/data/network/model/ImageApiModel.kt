package com.fueled.technicalchallenge.data.network.model

import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@Serializable
data class ImageApiModel(val path: String, val extension: String)
