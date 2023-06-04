package com.reihan.finalawalstory.ui.detail

import retrofit2.http.GET
import retrofit2.http.Path

interface DetailService {
    @GET("stories/{id}")
    suspend fun detailStory(@Path("id")id:String): DetailStoryResponse
}