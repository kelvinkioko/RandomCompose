package com.graph.randomcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.graph.randomcompose.finance.FinanceActivity
import com.graph.randomcompose.ui.theme.RandomComposeTheme
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {

    var isFirstRun: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        println("@@@ onCreate Called")
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

    override fun onStart() {
        super.onStart()
        println("@@@ onStart Called")
    }

    override fun onPause() {
        super.onPause()
        println("@@@ onPause Called")
    }

    override fun onRestart() {
        super.onRestart()
        println("@@@ onRestart Called")
    }

    override fun onResume() {
        super.onResume()
        println("@@@ onResume Called")

        if (isFirstRun) {
            isFirstRun = false
            val intent = Intent(this@MainActivity, FinanceActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStop() {
        super.onStop()
        println("@@@ onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("@@@ onDestroy Called")
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
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier
            .border(2.dp, Color.Green)
            .padding(50.dp)
            .border(2.dp, Color.Red)
            .padding(50.dp)
        ,
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