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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ) {
                ColoredSquare(color = Color.Cyan)
                ColoredSquare(color = Color.Red)
                ColoredSquare(color = Color.Black)
                ColoredSquare(color = Color.Blue)
                ColoredSquare(color = Color.Green)
            }
            ColoredSquare(color = Color.Cyan)
            ColoredSquare(color = Color.Red)
            ColoredSquare(color = Color.Black)
            ColoredSquare(color = Color.Blue)
            ColoredSquare(color = Color.Green)
        }

    }
}

@Composable
fun ColoredSquare(
    color: Color
) {
    Surface(
        color = color,
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
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