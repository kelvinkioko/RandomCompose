package com.graph.randomcompose.profile

import androidx.annotation.DrawableRes
import com.graph.randomcompose.R

data class ProfileEntity(
    val name: String,
    val status: Boolean = false,
    @DrawableRes val drawableID: Int = R.drawable.profile_picture
)

val profileList: List<ProfileEntity> = listOf(
    ProfileEntity(name = "Kelvin Kioko", status = true),
    ProfileEntity(name = "Takezo Kensei", status = false),
    ProfileEntity(name = "Olua Designer", status = true)
)
