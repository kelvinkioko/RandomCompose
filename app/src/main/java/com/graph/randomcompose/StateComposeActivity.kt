package com.graph.randomcompose

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class StateComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            NamesScreen()
        }
    }
}

@Composable
fun NamesScreen() {
    val greetingListState = remember {
        mutableStateListOf("Kelvin", "Donna", "Harvey", "Mike", "Jessica")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StateGreetingList(
            namesList = greetingListState,
            buttonClick = { greetingListState.add("Another name") }
        )
    }
}

@Composable
fun StateGreetingList(
    namesList: SnapshotStateList<String>,
    buttonClick: () -> Unit
) {
    for (name in namesList) {
        StateGreetingName(name = name)
    }

    val nameStateContent = remember { mutableStateOf("") }
    TextField(
        value = nameStateContent.value,
        onValueChange = {

        }
    )

    Button(
        onClick = buttonClick,
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
    ) {
        Text(text = "Add new name")
    }
}

@Composable
fun StateGreetingName(name: String) {
    Text(
        text = "Hello @ $name",
        style = MaterialTheme.typography.h5
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StateComposePreview() {
    NamesScreen()
}