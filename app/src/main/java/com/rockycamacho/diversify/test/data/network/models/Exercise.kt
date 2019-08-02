package com.rockycamacho.diversify.test.data.network.models

import com.squareup.moshi.Json

data class Exercise(
    @field:Json(name = "exercise")
    val name: String? = null,
    @field:Json(name = "description")
    val description: String? = null,
    @field:Json(name = "imageUrl")
    val imageUrl: String? = null,
    @field:Json(name = "targetMuscles")
    val targetMuscles: List<Muscle> = listOf()
)