package com.rockycamacho.diversify.test.data.network

import com.rockycamacho.diversify.test.data.network.models.Exercise
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("questions")
    fun getExercises(): Single<List<Exercise>>

}