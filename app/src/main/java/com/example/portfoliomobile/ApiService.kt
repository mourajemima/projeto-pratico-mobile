package com.example.portfoliomobile

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{user}/repos")
    suspend fun listRepos(@Path("user") user: String): List<ProjectDto>
}
