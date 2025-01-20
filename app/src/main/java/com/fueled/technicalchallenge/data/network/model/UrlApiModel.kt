package com.fueled.technicalchallenge.data.network.model

import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@Serializable
data class UrlApiModel(val type: String, val url: String)
