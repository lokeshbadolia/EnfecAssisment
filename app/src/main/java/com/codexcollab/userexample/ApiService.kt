package com.codexcollab.userexample

import retrofit2.http.GET
import retrofit2.Response

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<ArrayList<User>>
}