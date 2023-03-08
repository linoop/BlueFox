package com.linoop.bluefox.presentation

sealed class UserListViewState {
    object Loading : UserListViewState()
    object Error : UserListViewState()
    data class Content(val userList: List<UserListCardViewModel>) : UserListViewState()
}
