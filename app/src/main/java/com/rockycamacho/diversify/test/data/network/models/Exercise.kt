package com.rockycamacho.diversify.test.data.network.models

import android.os.Parcelable
import com.rockycamacho.diversify.test.di.OpenForTesting
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@OpenForTesting
@Parcelize
data class Exercise(
    @field:Json(name = "exercise")
    val name: String? = null,
    @field:Json(name = "description")
    val description: String? = null,
    @field:Json(name = "imageUrl")
    val imageUrl: String? = null,
    @field:Json(name = "targetMuscles")
    val targetMuscles: List<Muscle> = listOf()
): Parcelable