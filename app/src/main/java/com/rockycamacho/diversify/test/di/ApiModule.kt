package com.rockycamacho.diversify.test.di

import com.rockycamacho.diversify.test.data.network.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

@OpenForTesting
@Module
class ApiModule(private val apiEndpoint: String) {



    @Singleton
    @Provides
    fun apiService(
        okHttpClient: OkHttpClient,
        callAdapterFactory: CallAdapter.Factory,
        converterFactory: Converter.Factory
    ): ApiService =
        Retrofit.Builder()
            .baseUrl(apiEndpoint)
            .addCallAdapterFactory(callAdapterFactory)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)

    @Singleton
    @Provides
    fun okHttpClient(
        @Named("http-cache") cacheFile: File,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .cache(Cache(cacheFile, 10 * 1024 * 1024))
            .addNetworkInterceptor(httpLoggingInterceptor) //NOTE: should always be the last interceptor
            .build()

}
