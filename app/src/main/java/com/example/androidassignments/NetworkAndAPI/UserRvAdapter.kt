package com.example.androidassignments.NetworkAndAPI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidassignments.databinding.UserRvItemBinding


class UserRvAdapter(private var dataSet:ArrayList<UserItem>):
    RecyclerView.Adapter<UserRvAdapter.ViewHolder>() {

    class ViewHolder(private val binding: UserRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val userId = binding.textView31
        val userName = binding.textView32
        val userEmail = binding.textView33
        val userPhone = binding.textView34
        val userCompany = binding.textView35
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val userRvItemBinding =
            UserRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(userRvItemBinding)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userId.text = dataSet[position].id.toString()
        holder.userName.text = dataSet[position].name
        holder.userCompany.text = dataSet[position].company.name
        holder.userEmail.text = dataSet[position].email
        holder.userPhone.text = dataSet[position].phoneNum
    }
}


