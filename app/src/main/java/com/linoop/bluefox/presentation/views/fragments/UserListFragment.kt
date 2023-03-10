package com.linoop.bluefox.presentation.views.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.linoop.bluefox.R
import com.linoop.bluefox.databinding.FragmentUserListBinding
import com.linoop.bluefox.presentation.UserListCardViewModel
import com.linoop.bluefox.presentation.UserListViewState
import com.linoop.bluefox.presentation.views.MainActivity
import com.linoop.bluefox.presentation.viewModels.MainViewModel
import com.linoop.bluefox.presentation.views.UserListAdapter

class UserListFragment : Fragment(R.layout.fragment_user_list) {
    private lateinit var binding: FragmentUserListBinding
    private lateinit var context: MainActivity
    private lateinit var viewModel: MainViewModel

    private val adapter = UserListAdapter(::onItemClicked)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserListBinding.bind(view)
        context = (activity as MainActivity)
        viewModel = context.viewModel

        setupFragment()
    }

    private fun setupFragment() {
        viewModel.usersListViewSate.observe(viewLifecycleOwner) { updateUI(it) }
        setupProductRecyclerView()
        viewModel.getUsersList()
    }

    private fun setupProductRecyclerView() {
        binding.userList.layoutManager =
            GridLayoutManager(requireContext(), 2)
        binding.userList.hasFixedSize()
        binding.userList.adapter = adapter
    }

    private fun updateUI(viewState: UserListViewState) {
        when (viewState) {
            is UserListViewState.Content -> {
                binding.userList.isVisible = true
                binding.errorView.isVisible = false
                binding.loadingView.isVisible = false
                adapter.setData(viewState.userList)
            }
            UserListViewState.Error -> {
                binding.userList.isVisible = false
                binding.errorView.isVisible = true
                binding.loadingView.isVisible = false
            }
            UserListViewState.Loading -> {
                binding.userList.isVisible = false
                binding.errorView.isVisible = false
                binding.loadingView.isVisible = true
            }
            else -> {}
        }
    }

    private fun onItemClicked(userCardViewModel: UserListCardViewModel) {
        findNavController().navigate(
            UserListFragmentDirections.actionUserListFragmentToUserDetailsFragment(
                userCardViewModel.userId
            )
        )
    }
}