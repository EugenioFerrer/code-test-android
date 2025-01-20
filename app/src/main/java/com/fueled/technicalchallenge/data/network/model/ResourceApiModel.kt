package com.fueled.technicalchallenge.data.network.model

import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@Serializable
data class ResourceApiModel(val resourceURI: String, val name: String, val type: String?)
