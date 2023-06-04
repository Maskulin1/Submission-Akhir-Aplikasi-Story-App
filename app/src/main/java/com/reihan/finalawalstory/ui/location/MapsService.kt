package com.reihan.finalawalstory.ui.location

import retrofit2.http.GET
import retrofit2.http.Query

interface MapsService {
    @GET("stories")
    suspend fun fetchStoryWithCoordinates(@Query("location")location : String) : GetStoryResponse
}