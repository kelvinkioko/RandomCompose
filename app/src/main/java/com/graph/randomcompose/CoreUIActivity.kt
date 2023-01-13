package com.graph.randomcompose

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class CoreUIActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            CoreUiScreen()
        }
    }
}

@Composable
fun CoreUiScreen() {
    Surface(
        color = Color.Gray,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalColoredBar(color = Color.Cyan)
            HorizontalColoredBar(color = Color.Red)
            HorizontalColoredBar(color = Color.Black)
            HorizontalColoredBar(color = Color.Blue)
            HorizontalColoredBar(color = Color.Green)
        }

    }
}

@Composable
fun HorizontalColoredBar(
    color: Color
) {
    Surface(
        color = color,
        modifier = Modifier
            .width(350.dp)
            .height(60.dp)
    ) {
        Text(
            text = "",
            color = Color.White,
            style = MaterialTheme.typography.h3
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CoreUiScreenPreview() {
    CoreUiScreen()
}