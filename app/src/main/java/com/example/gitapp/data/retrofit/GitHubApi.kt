package com.example.gitapp.data.retrofit

import com.example.gitapp.domain.GitUserEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    @GET("users/{user}/repos")
    fun listUser(@Path("user") user:String?): Single<List<GitUserEntity>>
}