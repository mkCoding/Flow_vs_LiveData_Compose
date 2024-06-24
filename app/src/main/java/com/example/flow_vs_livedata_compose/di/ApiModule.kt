package com.example.flow_vs_livedata_compose.di

import com.example.flow_vs_livedata_compose.data.api.ApiDetails
import com.example.flow_vs_livedata_compose.data.api.ApiEndpoints
import com.example.flow_vs_livedata_compose.data.repository.ApiRepository
import com.example.flow_vs_livedata_compose.data.repository.ApiRepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)

//class that will provide dependencies that will be injected
//throughout the app
class ApiModule {

    @Provides
    fun providesRetrofit():Retrofit{
        //create okhttp (add interceptor)
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()

        //create retrofit instance
        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

    }


    //provides ApiEndpoint instance
    @Provides
    fun providesApiEndpoints(retrofit: Retrofit):ApiEndpoints{
        return retrofit.create(ApiEndpoints::class.java) //provides/returns creation of API Endpoints
    }

    //provide ApiRepository instance
    @Provides
    fun providesApiRepository(apiEndpoints: ApiEndpoints):ApiRepository{
        return ApiRepositoryImpl(apiEndpoints)
    }




}