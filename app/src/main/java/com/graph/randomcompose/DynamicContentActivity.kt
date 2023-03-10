package com.graph.randomcompose

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val namesList: ArrayList<String> = arrayListOf("Kelvin", "Donna", "Harvey", "Mike", "Jessica")

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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        for (name in names) {
            GreetingName(name = name)
        }

        Button(
            onClick = {
                namesList.add("Another name")
            },
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Add new name")
        }
    }
}

@Composable
fun GreetingName(name: String) {
    Text(
        text = "Hello @ $name",
        style = MaterialTheme.typography.h5
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DynamicContentPreview() {
    GreetingList(names = namesList)
}