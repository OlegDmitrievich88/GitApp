package com.example.gitapp

import android.app.Application
import android.content.Context
import com.example.gitapp.data.MockProjectRepoImpl
import com.example.gitapp.domain.RepoUserLogin

class App: Application() {

     val gitProjectRepo: RepoUserLogin by lazy { MockProjectRepoImpl() }
}

val Context.app: App
 get() = applicationContext as App