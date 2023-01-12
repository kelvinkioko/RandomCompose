package com.graph.randomcompose

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

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
        Surface(
            color = Color.Cyan,
            modifier = Modifier.wrapContentSize(align = Alignment.Center)
        ) {
            Text(
                text = "Wrapped content",
                style = MaterialTheme.typography.h3
            )
            Text(
                text = "More wrapped content",
                color = Color.Red,
                style = MaterialTheme.typography.h3
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CoreUiScreenPreview() {
    CoreUiScreen()
}