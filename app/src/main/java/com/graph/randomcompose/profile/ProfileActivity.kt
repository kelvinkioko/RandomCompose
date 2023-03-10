package com.graph.randomcompose.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.graph.randomcompose.ui.theme.LightGreen
import com.graph.randomcompose.ui.theme.RandomComposeTheme

class ProfileActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomComposeTheme {
                UsersApplication()
            }
        }
    }
}

@Composable
fun UsersApplication(userProfiles: List<ProfileEntity> = profileList) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "users_list",
        builder = {
            composable(route = "users_list") {
                UsersListScreen(
                    navController = navController,
                    userProfiles = userProfiles
                )
            }
            composable(
                route = "users_details/{userId}",
                arguments = listOf(navArgument("userId") {
                    type = NavType.IntType
                })
            ) {
                println("@@@ ${it.arguments?.getInt("userId")}")
                UserProfileDetailsScreen(
                    navController = navController,
                    userID = it.arguments?.getInt("userId")
                )
            }
        }
    )
}

@Composable
fun UsersListScreen(
    navController: NavHostController?,
    userProfiles: List<ProfileEntity>
) {
    Scaffold(
        topBar = {
            ToolBar(
                title = "Users list",
                icon = Icons.Default.Home,
                iconClickAction = {}
            )
        }
    ) { padding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyColumn {
                items(userProfiles) { profile ->
                    ProfileCard(
                        profileEntity = profile,
                        clickAction = {
                            navController?.navigate(route = "users_details/${profile.id}")
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ToolBar(title: String, icon: ImageVector, iconClickAction: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .clickable(onClick = { iconClickAction.invoke() })
            )
        }
    )
}

@Composable
fun ProfileCard(profileEntity: ProfileEntity, clickAction: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clickable(onClick = clickAction)
        ,
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(
                drawableId = profileEntity.drawableID,
                onlineStatus = profileEntity.status
            )
            ProfileContent(
                userName = profileEntity.name,
                onlineStatus = profileEntity.status
            )
        }
    }
}

@Composable
fun ProfilePicture(@DrawableRes drawableId: Int, onlineStatus: Boolean, imageSize: Dp = 72.dp) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = if (onlineStatus)
                MaterialTheme.colors.LightGreen
            else
                Color.Red

        ),
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
        elevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = drawableId),
            contentDescription = "",
            modifier = Modifier.size(imageSize),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileContent(userName: String, onlineStatus: Boolean, alignment: Alignment.Horizontal = Alignment.Start) {
    Column(
        modifier = Modifier
            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp),
        horizontalAlignment = alignment
    ) {
        CompositionLocalProvider(
            LocalContentAlpha provides (if (onlineStatus) 1f else ContentAlpha.medium)
        ) {
            Text(
                text = userName,
                style = MaterialTheme.typography.h5
            )
        }

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
            Text(
                text = if (onlineStatus) "Active now" else "Offline",
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StateComposePreview() {
    RandomComposeTheme {
        UsersListScreen(
            navController = null,
            userProfiles = profileList
        )
    }
}

@Composable
fun UserProfileDetailsScreen(
    navController: NavHostController?,
    userID: Int?
) {
    val profileEntity = profileList.find { it.id == userID }
    Scaffold(
        topBar = {
            ToolBar(
                title = "User details",
                icon = Icons.Default.ArrowBack,
                iconClickAction = {
                    navController?.navigateUp()
                }
            )
        }
    ) { padding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                profileEntity?.let {
                    ProfilePicture(
                        drawableId = profileEntity.drawableID,
                        onlineStatus = profileEntity.status,
                        imageSize = 240.dp
                    )
                    ProfileContent(
                        userName = profileEntity.name,
                        onlineStatus = profileEntity.status,
                        alignment = Alignment.CenterHorizontally
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserProfileDetailsPreview() {
    RandomComposeTheme {
        UserProfileDetailsScreen(
            navController = null,
            userID = 0
        )
    }
}
