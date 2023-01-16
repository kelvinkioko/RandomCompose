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
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class StateComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NamesScreen()
        }
    }
}

@Composable
fun NamesScreen(viewModel: StateComposeViewModel = StateComposeViewModel()) {
    val greetingListState = remember {
        mutableStateListOf("Kelvin", "Donna", "Harvey", "Mike", "Jessica")
    }
    val nameStateContent = viewModel.textFieldState.observeAsState("Hello")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StateGreetingList(
            namesList = greetingListState,
            textFieldValue = nameStateContent.value,
            textFieldUpdate = { nameUpdate ->
                println("@@@ $nameUpdate")
                println("@@@ ${nameStateContent.value}")
//                viewModel.onNameChangenged(newName = nameUpdate)
                              },
            buttonClick = { greetingListState.add(nameStateContent.value) }
        )
    }
}

@Composable
fun StateGreetingList(
    namesList: SnapshotStateList<String>,
    textFieldValue: String,
    textFieldUpdate: (newName: String) -> Unit,
    buttonClick: () -> Unit
) {
    for (name in namesList) {
        StateGreetingName(name = name)
    }

    TextField(
        value = textFieldValue,
        onValueChange = textFieldUpdate
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