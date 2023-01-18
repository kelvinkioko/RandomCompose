package com.graph.randomcompose.profile

import androidx.annotation.DrawableRes
import com.graph.randomcompose.R

data class ProfileEntity(
    val id: Int,
    val name: String,
    val status: Boolean = false,
    @DrawableRes val drawableID: Int = R.drawable.profile_picture,
    val profileImage: String = "https://images.unsplash.com/photo-1669792681519-14afd73bd205?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3100&q=80"
)

val profileList: List<ProfileEntity> = listOf(
    ProfileEntity(id = 0, name = "Kelvin Kioko", status = true),
    ProfileEntity(id = 1, name = "Takezo Kensei", status = false),
    ProfileEntity(id = 2, name = "Olua Designer", status = true),
    ProfileEntity(id = 3, name = "Takezo Kensei", status = false),
    ProfileEntity(id = 4, name = "Olua Designer", status = true),
    ProfileEntity(id = 5, name = "Takezo Kensei", status = false),
    ProfileEntity(id = 6, name = "Olua Designer", status = true),
    ProfileEntity(id = 7, name = "Takezo Kensei", status = false),
    ProfileEntity(id = 8, name = "Olua Designer", status = true)
)
