package com.example.gitapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gitapp.domain.RepoUserLogin

class RepoViewModelFactory(private val repo: RepoUserLogin): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserRepoViewModel(repo) as T
    }
}