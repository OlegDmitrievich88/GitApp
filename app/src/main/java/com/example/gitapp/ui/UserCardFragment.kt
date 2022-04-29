package com.example.gitapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gitapp.databinding.UserCardFragmentBinding

class UserCardFragment: Fragment() {

    private lateinit var binding: UserCardFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = UserCardFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }
}