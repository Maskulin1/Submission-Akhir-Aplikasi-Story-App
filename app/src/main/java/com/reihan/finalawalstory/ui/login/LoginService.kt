package com.reihan.finalawalstory.ui.login

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {
    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
        @Field("email")email: String,
        @Field("password")password : String
    ) : LoginResponse
}