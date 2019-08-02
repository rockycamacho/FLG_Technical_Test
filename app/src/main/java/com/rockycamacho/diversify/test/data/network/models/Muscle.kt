package com.rockycamacho.diversify.test.data.network.models

import com.squareup.moshi.Json

data class Muscle(
    @field:Json(name = "name")
    val name: String? = null,
    @field:Json(name = "description")
    val description: String? = null
)