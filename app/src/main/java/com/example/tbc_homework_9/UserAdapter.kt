package com.example.tbc_homework_9

import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tbc_homework_9.databinding.ItemUserBinding

class UserAdapter(
    var users: List<User>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(layoutInflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.apply {
            firstNameView.text = users[position].first_Name
            lastNameView.text = users[position].Last_name
            emailView.text = users[position].email

            holder.binding.deleteButton.setOnClickListener {

            }
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root){

    }

}