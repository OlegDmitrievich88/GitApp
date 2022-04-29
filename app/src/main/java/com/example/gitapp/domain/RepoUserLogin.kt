package com.example.gitapp.domain

import io.reactivex.rxjava3.core.Single

interface RepoUserLogin {
    fun getUserList(username:String): Single<List<GitUserEntity>>

}