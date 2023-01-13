package com.graph.randomcompose

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

val namesList: List<String> = listOf("Kelvin", "Donna", "Harvey", "Mike", "Jessica")

class DynamicContentActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            GreetingList(names = namesList)
        }
    }
}

@Composable
fun GreetingList(names: List<String>) {
    Column {
        for (name in names) {
            GreetingName(name = name)
        }
    }
}

@Composable
fun GreetingName(name: String) {
    Text(text = name)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DynamicContentPreview() {
    GreetingList(names = namesList)
}