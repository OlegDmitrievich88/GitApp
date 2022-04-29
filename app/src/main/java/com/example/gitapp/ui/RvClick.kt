package com.example.gitapp.ui

import com.example.gitapp.domain.GitUserEntity

interface RvClick {
    fun onItemClicked(position: GitUserEntity)
}