package com.linoop.bluefox.presentation.views.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.linoop.bluefox.R
import com.linoop.bluefox.business.UserModel
import com.linoop.bluefox.databinding.FragementCreateUserBinding
import com.linoop.bluefox.presentation.viewModels.MainViewModel
import com.linoop.bluefox.presentation.viewModels.UserRegFormState
import com.linoop.bluefox.presentation.views.MainActivity
import com.linoop.bluefox.utils.DatabaseResult

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
        viewModel.createUserResult.observeEvent(viewLifecycleOwner) { updateUI(it) }
        binding.save.setOnClickListener { saveUser() }
        binding.cancel.setOnClickListener { context.goBack() }
        viewModel.userDataValidation.observe(viewLifecycleOwner) {
            binding.name.error = it.nameError
            binding.email.error = it.emailError
            binding.address.error = it.addressError
            binding.password.error = it.passwordError
            binding.confirmPassword.error = it.confirmPasswordError
        }
    }

    private fun updateUI(result: DatabaseResult<Long>?) = result?.let {
        when (it) {
            is DatabaseResult.Success -> {
                binding.email.editText?.setText("")
                binding.name.editText?.setText("")
                binding.address.editText?.setText("")
                binding.password.editText?.setText("")
                binding.confirmPassword.editText?.setText("")
                context.showMessage("Success", "User created successfully, ID${it.data}")
            }
            is DatabaseResult.Error -> {
                context.showMessage("Error", it.exception.message.toString())
            }
        }
    }


    private fun saveUser() {
        val email = binding.email.editText?.text.toString().trim()
        val name = binding.name.editText?.text.toString().trim()
        val address = binding.address.editText?.text.toString().trim()
        val password = binding.password.editText?.text.toString().trim()
        val confirmPassword = binding.confirmPassword.editText?.text.toString().trim()
        val userRegFormState = UserRegFormState(
            name = name,
            email = email,
            address = address,
            password = password,
            confirmPassword = confirmPassword
        )
        viewModel.createUser(userRegFormState)
    }
}