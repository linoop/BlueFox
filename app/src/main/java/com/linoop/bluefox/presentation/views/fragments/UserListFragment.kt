package com.linoop.bluefox.presentation.views.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.linoop.bluefox.R
import com.linoop.bluefox.databinding.FragementUserListBinding
import com.linoop.bluefox.presentation.views.MainActivity
import com.linoop.bluefox.presentation.viewModels.MainViewModel

class UserListFragment: Fragment(R.layout.fragement_user_list) {
    private lateinit var binding: FragementUserListBinding
    private lateinit var context: MainActivity
    private lateinit var viewModel: MainViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragementUserListBinding.bind(view)
        context = (activity as MainActivity)
        viewModel = context.viewModel
    }
}