package com.example.gitapp.data.retrofit

import com.example.gitapp.domain.GitUserEntity
import com.example.gitapp.domain.RepoUserLogin
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProjectRepoImpl : RepoUserLogin {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
    private var api: GitHubApi = retrofit.create(GitHubApi::class.java)


    override fun getUserList(username: String): Single<List<GitUserEntity>> {
        return api.listUser(username)
//        return Single.create{ emitter->
//            val call = api.listUser(username)
//            call.enqueue(object : Callback<List<GitUserEntity>> {
//                override fun onResponse(
//                    call: Call<List<GitUserEntity>>,
//                    response: Response<List<GitUserEntity>>
//                ) {
//                    response.body()?.let { emitter.onSuccess(it) }
//                }
//
//                override fun onFailure(call: Call<List<GitUserEntity>>, t: Throwable) {
//                   emitter.onError(t)
//                }
//
//            })
//
//        }
    }
}