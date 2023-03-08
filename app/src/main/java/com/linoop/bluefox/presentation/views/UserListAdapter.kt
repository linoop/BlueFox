package com.linoop.bluefox.presentation.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.linoop.bluefox.R
import com.linoop.bluefox.databinding.CardViewUserBinding
import com.linoop.bluefox.presentation.UserListCardViewModel

class UserListAdapter(
    val onItemClicked: (UserListCardViewModel) -> Unit,
) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {


    private var data: List<UserListCardViewModel> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(productList: List<UserListCardViewModel>) {
        this.data = productList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(userListCardViewModel: UserListCardViewModel) {
            val bind = CardViewUserBinding.bind(itemView)
            itemView.setOnClickListener {
                onItemClicked(userListCardViewModel)
            }
            bind.apply {
                name.text = userListCardViewModel.name
                email.text = userListCardViewModel.email
                address.text = userListCardViewModel.address
            }
        }

    }
}