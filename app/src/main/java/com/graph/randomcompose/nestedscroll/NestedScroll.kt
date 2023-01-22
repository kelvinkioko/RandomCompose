package com.graph.randomcompose.nestedscroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.graph.randomcompose.Greeting
import com.graph.randomcompose.GreetingButton
import com.graph.randomcompose.ui.theme.RandomComposeTheme

class NestedScroll : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RandomNestedScrollScreen()
                }
            }
        }
    }
}

@Composable
private fun RandomNestedScrollScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            HorizontalSubList()
        }
        verticalSubList()
    }
}

@Composable
private fun HorizontalSubList() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(10) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Cyan)
            )
        }
    }
}

private fun LazyListScope.verticalSubList() {
    items(10) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.Green)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NestedScrollPreview() {
    RandomComposeTheme {
        RandomNestedScrollScreen()
    }
}
