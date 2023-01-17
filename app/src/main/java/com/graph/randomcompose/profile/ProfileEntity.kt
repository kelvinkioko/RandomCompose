package com.graph.randomcompose.profile

import androidx.annotation.DrawableRes
import com.graph.randomcompose.R

data class ProfileEntity(
    val name: String,
    val status: Boolean = false,
    @DrawableRes val drawableID: Int = R.drawable.profile_picture,
    val profileImage: String = "https://images.unsplash.com/photo-1669792681519-14afd73bd205?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3100&q=80"
)

val profileList: List<ProfileEntity> = listOf(
    ProfileEntity(name = "Kelvin Kioko", status = true),
    ProfileEntity(name = "Takezo Kensei", status = false),
    ProfileEntity(name = "Olua Designer", status = true),
    ProfileEntity(name = "Takezo Kensei", status = false),
    ProfileEntity(name = "Olua Designer", status = true),
    ProfileEntity(name = "Takezo Kensei", status = false),
    ProfileEntity(name = "Olua Designer", status = true),
    ProfileEntity(name = "Takezo Kensei", status = false),
    ProfileEntity(name = "Olua Designer", status = true)
)
