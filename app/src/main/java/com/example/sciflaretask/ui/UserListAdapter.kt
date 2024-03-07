package com.example.sciflaretask.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sciflaretask.R
import com.example.sciflaretask.databinding.ItemUserBinding
import com.example.sciflaretask.model.DBModel

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    private var userList  = listOf<DBModel.User>()

    class ViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    fun setData(userList : List<DBModel.User>){

        this.userList = userList

        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder =
        ViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {

            holder.itemView.context.let { context ->

                userList[position].let { user ->

                    txtName.text = user.name

                    txtGender.text = context.getString(R.string.label_gender, user.gender)

                    txtEmail.text = context.getString(R.string.label_email, user.email)

                    txtPhone.text = context.getString(R.string.label_phone, user.mobile)

                }

            }

        }

    }

}