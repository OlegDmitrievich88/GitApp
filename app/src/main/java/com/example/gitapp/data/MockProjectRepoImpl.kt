package com.example.gitapp.data

import com.example.gitapp.domain.GitUserEntity
import com.example.gitapp.domain.RepoUserLogin
import io.reactivex.rxjava3.core.Single

class MockProjectRepoImpl:RepoUserLogin {

    override fun getUserList(username: String): Single<List<GitUserEntity>> {
        val testList = listOf(
            GitUserEntity("1"),
            GitUserEntity("1"),
            GitUserEntity("1"),
            GitUserEntity("1"),
            GitUserEntity("1"),
            GitUserEntity("1"),
            GitUserEntity("1"),
            GitUserEntity("1"),
            GitUserEntity("1"),
            GitUserEntity("1"),

        )
        return Single.just(testList)
    }

}