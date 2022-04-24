package com.example.gitapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gitapp.domain.GitUserEntity
import com.example.gitapp.domain.RepoUserLogin
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class UserRepoViewModel(private val userLogin: RepoUserLogin): ViewModel() {

   private val _repos = MutableLiveData<List<GitUserEntity>>()
    val repos: LiveData<List<GitUserEntity>> = _repos
    private val  compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun onShowUser(username: String){
        compositeDisposable.addAll(
        userLogin.getUserList(username).subscribeBy {
            _repos.postValue(it)
        })
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}