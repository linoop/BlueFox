package com.linoop.bluefox.presentation.views.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.linoop.bluefox.R
import com.linoop.bluefox.business.UserModel
import com.linoop.bluefox.databinding.FragmentUserDetailsBinding
import com.linoop.bluefox.presentation.viewModels.MainViewModel
import com.linoop.bluefox.presentation.views.MainActivity
import com.linoop.bluefox.utils.DatabaseResult

class UserDetailsFragment : Fragment(R.layout.fragment_user_details) {
    private lateinit var binding: FragmentUserDetailsBinding
    private lateinit var context: MainActivity
    private lateinit var viewModel: MainViewModel
    private val args: UserDetailsFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserDetailsBinding.bind(view)
        context = (activity as MainActivity)
        viewModel = context.viewModel
        setupFragment()
    }

    private fun setupFragment() {
        viewModel.userDetails.observe(viewLifecycleOwner) { updateUI(it) }
        binding.save.setOnClickListener { }
        binding.cancel.setOnClickListener { context.goBack() }
        viewModel.getUserByID(args.userId)
    }

    private fun updateUI(result: DatabaseResult<UserModel>)  {
        when (result) {
            is DatabaseResult.Success -> {
                binding.username.text = result.data.name
            }
            is DatabaseResult.Error -> {
                context.showMessage("Error", result.exception.message.toString())
            }
        }
    }

}