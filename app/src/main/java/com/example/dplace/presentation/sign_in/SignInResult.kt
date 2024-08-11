package com.example.dplace.presentation.sign_in

data class SignInResult(
    val data: UserData?,
    val errorMessage: String?
)

data class UserData(
    val userid: String,
    val username: String,
    val profilePictureUrl: String?
)
