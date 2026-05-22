package com.sri.testnetworkcall.ui.screens.home.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UsersRespItem(
    val address: String? = null,
    val company: String? = null,
    val country: String? = null,
    val email: String? = null,
    val id: Int? = null,
    val name: String? = null,
    val phone: String? = null,
    val photo: String? = null,
    val state: String? = null,
    val username: String? = null,
    val zip: String? = null
) : Parcelable