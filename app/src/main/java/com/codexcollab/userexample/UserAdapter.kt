package com.codexcollab.userexample

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codexcollab.userexample.databinding.LayoutUserViewBinding

class UserAdapter(
    private val context: Context
): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val list = arrayListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder = UserViewHolder(
        LayoutUserViewBinding.inflate(LayoutInflater.from(context), parent, false))

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        if (list.isNotEmpty()) {
            val user = list[position]
            holder.binding.id.text = user.id.toString()
            holder.binding.name.text = user.name
            holder.binding.email.text = user.email
            user.address?.let { add ->
                holder.binding.address.text = "${add.street?.takeIf { it.isNotBlank() }}," +
                        " ${add.city?.takeIf { it.isNotBlank() }}," +
                        " ${add.zipcode?.takeIf { it.isNotBlank() }}"
                add.geo?.let {geo ->
                    holder.binding.latLong.text = "${geo.lat ?: 0}, ${geo.long ?: 0}"
                }
            }
        }
    }

    override fun getItemCount(): Int = list.size

    fun fillUsers(listUsers: ArrayList<User>) {
        list.clear()
        list.addAll(listUsers)
        notifyDataSetChanged()
    }

    class UserViewHolder(val binding: LayoutUserViewBinding): RecyclerView.ViewHolder(binding.root)
}