package com.graph.randomcompose.finance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.graph.randomcompose.ui.theme.RandomComposeTheme

class FinanceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FinanceSplashScreen()
                }
            }
        }
    }
}

@Composable
private fun FinanceHomeScreen() {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun FinanceHomeScreenPreview() {
    RandomComposeTheme {
        FinanceHomeScreen()
    }
}
