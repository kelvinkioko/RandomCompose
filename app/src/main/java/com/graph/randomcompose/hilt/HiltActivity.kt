package com.graph.randomcompose.hilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.graph.randomcompose.hilt.database.DatabaseAdapter
import com.graph.randomcompose.hilt.database.DatabaseService
import com.graph.randomcompose.hilt.di.CallInterceptor
import com.graph.randomcompose.hilt.di.ResponseInterceptor
import com.graph.randomcompose.hilt.network.NetworkAdapter
import com.graph.randomcompose.hilt.network.NetworkService
import com.graph.randomcompose.ui.theme.RandomComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltActivity : ComponentActivity() {

    @Inject lateinit var databaseAdapter: DatabaseAdapter
//    @Inject lateinit var networkAdapter: NetworkAdapter
    @CallInterceptor
    @Inject lateinit var callNetworkService: NetworkService
    @CallInterceptor
    @Inject lateinit var callNetworkService1: NetworkService
    @CallInterceptor
    @Inject lateinit var callNetworkService2: NetworkService

    @ResponseInterceptor
    @Inject lateinit var responseNetworkService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        println("@@@ MainActivity: $databaseAdapter")
//        databaseAdapter.log(message = "This was called from HiltActivity")

//        println("@@@ MainActivity Network Adapter: $networkAdapter")
//        networkAdapter.log(message = "Network Adapter logged")

        println("@@@ MainActivity Call Network Service: $callNetworkService")
        callNetworkService.performNetworkCall()
        println("@@@ MainActivity Call Network Service: $callNetworkService1")
        println("@@@ MainActivity Call Network Service: $callNetworkService2")

//        println("@@@ MainActivity Response Network Service: $responseNetworkService")
//        responseNetworkService.performNetworkCall()
        setContent {
            RandomComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HiltGreeting("Hello Student")
                }
            }
        }
    }

    @Inject
    fun directToDatabase(databaseService: DatabaseService) {
        databaseService.log("Injection from method")
    }
}

@Composable
fun HiltGreetingButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .width(200.dp)
            .height(80.dp)
    ) {
        HiltGreeting(name = "Kelvin ")
    }
}

@Composable
fun HiltGreeting(name: String) {
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
fun DefaultHiltPreview() {
    RandomComposeTheme {
        HiltGreetingButton()
    }
}