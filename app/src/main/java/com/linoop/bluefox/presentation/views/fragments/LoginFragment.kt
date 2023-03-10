package com.linoop.bluefox.presentation.views.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.linoop.bluefox.R
import com.linoop.bluefox.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        setupFragment()
    }

    private fun setupFragment() {
        binding.login.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToUserListFragment())
        }
        binding.gotoCreateUser.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToCreateUserFragment())
        }
    }
}