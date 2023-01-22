package com.graph.randomcompose.finance

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.graph.randomcompose.R
import com.graph.randomcompose.ui.theme.*

@Composable
fun FinanceSplashScreen() {
    Column {
        Logo()
        Hero()
    }

    MainImage()

    Box(
        modifier = Modifier.size(60.dp),
        contentAlignment = Alignment.Center
    ) {
        NextButton()
    }
}

@Composable
fun NextButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(60.dp),
        backgroundColor = PrimaryGrey
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "",
            tint = Color.White
        )
    }
}

@Composable
fun MainImage() {
    Image(
        painter = painterResource(id = R.drawable.undraw_investing),
        contentDescription = "",
        alignment = Alignment.BottomCenter,
        modifier = Modifier
            .padding(vertical = 60.dp, horizontal = 20.dp)
    )
}

@Composable
fun Hero() {
    val annotatedTitle = AnnotatedString
        .Builder("Finance Your Balance Sheet")
        .apply {
            addStyle(
                style = SpanStyle(
                    color = PrimaryRed,
                    fontFamily = poppins,
                    textDecoration = TextDecoration.Underline
                ),
                start = 12,
                end = 12
            )
        }

    val annotatedDescription = AnnotatedString
        .Builder("Best payment method, connects your money to your friends and brands")
        .apply {
            addStyle(
                style = SpanStyle(
                    color = PrimaryGrey,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppins
                ),
                start = 49,
                end = 67
            )
        }

    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Text(
            text = annotatedTitle.toAnnotatedString(),
            fontSize = 46.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 50.sp,
            color = PrimaryGrey
        )

        Text(
            text = annotatedDescription.toAnnotatedString(),
            fontWeight = FontWeight.Bold,
            color = LightGrey2
        )
    }
}

@Composable
private fun Logo() {
    Row(
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic__square),
            contentDescription = "",
            tint = Color.Unspecified
        )

        Text(
            text = "FinBud",
            modifier = Modifier
                .padding(start = 12.dp)
                .alpha(0.8f),
            fontSize = 16.sp,
            fontFamily = poppins,
            color = Color.DarkGray
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun FinanceSplashScreenPreview() {
    RandomComposeTheme {
        FinanceSplashScreen()
    }
}