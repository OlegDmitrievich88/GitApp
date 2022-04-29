package com.example.gitapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gitapp.databinding.ItemForUserLoginListBinding
import com.example.gitapp.domain.GitUserEntity

class RvUserListAdapter(private val itemClick: RvClick): RecyclerView.Adapter<RvUserListAdapter.UserLoginViewHolder>() {

     private var data: List<GitUserEntity> = emptyList()

   fun setData(user: List<GitUserEntity>){
       data = user
       notifyDataSetChanged()
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserLoginViewHolder {
        return UserLoginViewHolder.onCreate(parent)
    }

    override fun onBindViewHolder(holder: UserLoginViewHolder, position: Int) {
        holder.bind(getItemPos(position),itemClick)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    private fun getItemPos(pos: Int):GitUserEntity{
        return data[pos]
    }

    class UserLoginViewHolder(private val binding: ItemForUserLoginListBinding) :
        RecyclerView.ViewHolder(binding.root) {

            companion object{
                fun onCreate(parent: ViewGroup): UserLoginViewHolder {
                    val inflater = LayoutInflater.from(parent.context)
                    return UserLoginViewHolder(ItemForUserLoginListBinding.inflate(inflater), )
                }
            }
//private val itemClick: RvClick
        fun bind(item: GitUserEntity,itemClick: RvClick){
            binding.userNameTextView.text = item.name.toString()
            binding.itemForRv.setOnClickListener {
                itemClick.onItemClicked(item)
            }
        }

    }
}