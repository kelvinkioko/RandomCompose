package com.graph.randomcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.graph.randomcompose.ui.theme.RandomComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Hello Student")
                }
            }
        }
    }
}

@Composable
fun GreetingButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .width(200.dp)
            .height(80.dp)
    ) {
        Greeting(name = "Kelvin ")
        Greeting(name = "Kioko")
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier
            .fillMaxWidth(0.5f),
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.SemiBold
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    RandomComposeTheme {
        GreetingButton()
    }
}