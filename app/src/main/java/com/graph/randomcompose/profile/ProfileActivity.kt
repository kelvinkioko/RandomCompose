package com.graph.randomcompose.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.google.accompanist.coil.rememberCoilPainter
import com.graph.randomcompose.ui.theme.LightGreen
import com.graph.randomcompose.ui.theme.RandomComposeTheme

class ProfileActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomComposeTheme {
                UsersListScreen()
            }
        }
    }
}

@Composable
fun UsersApplication() {

}

@Composable
fun UsersListScreen() {
    Scaffold(
        topBar = { ToolBar() }
    ) { padding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyColumn {
                items(profileList) { profile ->
                    ProfileCard(profileEntity = profile)
                }
            }
        }
    }
}

@Composable
fun ToolBar() {
    TopAppBar(
        title = { Text(text = "Veterenary Patient profile") },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "",
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        }
    )
}

@Composable
fun ProfileCard(profileEntity: ProfileEntity) {
    Card(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
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
            painter = rememberCoilPainter(
                request = drawableId,
                requestBuilder = {
                    transformations(CircleCropTransformation())
                }
            ),
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
        UsersListScreen()
    }
}

@Composable
fun UserProfileDetailsScreen(profileEntity: ProfileEntity = profileList[0]) {
    Scaffold(
        topBar = { ToolBar() }
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserProfileDetailsPreview() {
    RandomComposeTheme {
        UserProfileDetailsScreen()
    }
}
