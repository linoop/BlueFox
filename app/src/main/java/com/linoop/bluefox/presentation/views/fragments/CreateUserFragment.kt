package com.linoop.bluefox.presentation.views.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.linoop.bluefox.R
import com.linoop.bluefox.business.UserModel
import com.linoop.bluefox.databinding.FragementCreateUserBinding
import com.linoop.bluefox.presentation.viewModels.MainViewModel
import com.linoop.bluefox.presentation.views.MainActivity

class CreateUserFragment : Fragment(R.layout.fragement_create_user) {
    private lateinit var binding: FragementCreateUserBinding
    private lateinit var context: MainActivity
    private lateinit var viewModel: MainViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragementCreateUserBinding.bind(view)
        context = (activity as MainActivity)
        viewModel = context.viewModel

        setupFragment()
    }

    private fun setupFragment() {
        binding.save.setOnClickListener { saveUser() }
        binding.cancel.setOnClickListener { context.goBack() }
    }

    private fun saveUser() {
        val email = binding.email.editText?.text.toString().trim()
        val name = binding.name.editText?.text.toString().trim()
        val address = binding.address.editText?.text.toString().trim()
        val user = UserModel(0, name, email, address)
        viewModel.createUser(user)
    }
}