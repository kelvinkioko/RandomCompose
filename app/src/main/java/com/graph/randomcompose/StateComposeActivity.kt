package com.graph.randomcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class StateComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NamesScreen()
        }
    }
}

@Composable
fun NamesScreen(stateViewModel: StateComposeViewModel = viewModel()) {
    val anotherStateName = stateViewModel.nameState.observeAsState("")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StateGreetingList(
            textFieldValue = anotherStateName.value,
            textFieldUpdate = { nameUpdate -> stateViewModel.onNameChanged(newName = nameUpdate) },
            buttonClick = {  }
        )
    }
}

@Composable
fun StateGreetingList(
    textFieldValue: String,
    textFieldUpdate: (newName: String) -> Unit,
    buttonClick: () -> Unit
) {
    TextField(
        value = textFieldValue,
        onValueChange = textFieldUpdate,
        isError = true
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