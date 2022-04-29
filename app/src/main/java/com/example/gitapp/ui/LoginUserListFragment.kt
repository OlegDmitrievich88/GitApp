package com.example.gitapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitapp.R
import com.example.gitapp.app
import com.example.gitapp.databinding.LoginUserListFragmentBinding
import com.example.gitapp.domain.GitUserEntity

class LoginUserListFragment : Fragment(),RvClick {

    private lateinit var binding: LoginUserListFragmentBinding
    private val viewModelListUser: UserRepoViewModel by activityViewModels {RepoViewModelFactory(
        context?.app!!.gitProjectRepo)}
    private val adapter = RvUserListAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginUserListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        goingEvents()
        initIncomingEvents()

    }

    private fun goingEvents() {
        val OlegDmitrievich88 = "OlegDmitrievich88"
        viewModelListUser.onShowUser(OlegDmitrievich88)
    }

    private fun initIncomingEvents() {
        viewModelListUser.repos.observe(viewLifecycleOwner){
        adapter.setData(it)
        }
    }
    private fun initView() {
        with(binding) {
            rwUserList.layoutManager = LinearLayoutManager(activity)
            adapter.setHasStableIds(true)
            rwUserList.adapter = adapter
        }
    }

    override fun onItemClicked(position: GitUserEntity) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container,UserCardFragment())
            .addToBackStack("")
            .commit()
    }


}
