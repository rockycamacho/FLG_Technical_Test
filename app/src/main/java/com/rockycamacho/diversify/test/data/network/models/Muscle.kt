package com.rockycamacho.diversify.test.data.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Muscle(
    @field:Json(name = "name")
    val name: String? = null,
    @field:Json(name = "description")
    val description: String? = null
): Parcelable