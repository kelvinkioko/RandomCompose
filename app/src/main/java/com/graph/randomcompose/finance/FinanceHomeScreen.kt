package com.graph.randomcompose.finance

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.graph.randomcompose.R
import com.graph.randomcompose.ui.theme.*

@Composable
fun FinanceHomeScreen() {
    val sendMoneyData: List<SendMoney> = arrayListOf(
        SendMoney(image = R.drawable.user1, name = "Smith", amount = "$55.90"),
        SendMoney(image = R.drawable.user2, name = "Hellen", amount = "$156.54"),
        SendMoney(image = R.drawable.user3, name = "Sergio", amount = "$840.36"),
        SendMoney(image = R.drawable.user2, name = "Hellen", amount = "$173.33")
    )

    Column() {
        HeaderUI()
        CardUI()
        DataUI()
        ServicesUI()

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )

        SendMoneyUI(sendMoneyData = sendMoneyData)
    }
}

data class SendMoney(
    @DrawableRes val image: Int,
    val name: String,
    val amount: String
)

@Composable
fun SendMoneyUI(sendMoneyData: List<SendMoney>) {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Text(
            text = "Send Money",
            color = PrimaryGrey,
            fontFamily = poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(sendMoneyData) { sendMoney ->
                Card {
                    Column(
                        modifier = Modifier
                            .background(color = Color.White)
                            .padding(
                                start = 16.dp,
                                top = 10.dp,
                                end = 16.dp,
                                bottom = 10.dp
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Card(
                            shape = CircleShape
                        ) {
                            Image(
                                painter = painterResource(id = sendMoney.image),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(70.dp)
                                    .border(width = 0.dp, color = Color.Transparent, shape = Shapes.medium)
                                    .clip(Shapes.medium)
                            )
                        }

                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )

                        Text(
                            text = sendMoney.name,
                            color = PrimaryGrey,
                            modifier = Modifier.alpha(0.6f),
                            fontSize = 14.sp,
                            fontFamily = poppins
                        )

                        Text(
                            text = sendMoney.amount,
                            color = PrimaryGrey,
                            fontSize = 16.sp,
                            fontFamily = poppins,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ServicesUI() {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Text(
            text = "Services",
            color = PrimaryGrey,
            fontFamily = poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SingleServiceUI(icon = R.drawable.ic_money_send, title = "Send", color = Service1)
            SingleServiceUI(icon = R.drawable.ic_bill, title = "Bill", color = Service2)
            SingleServiceUI(icon = R.drawable.ic_recharge, title = "Recharge", color = Service3)
            SingleServiceUI(icon = R.drawable.ic_more, title = "More", color = Service4)
        }
    }
}

@Composable
fun SingleServiceUI(@DrawableRes icon: Int, title: String, color: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(60.dp),
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = color)
        ) {
            Icon(painter = painterResource(id = icon), contentDescription = "")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = title,
            color = PrimaryGrey,
            modifier = Modifier.alpha(0.6f),
            fontSize = 14.sp,
            fontFamily = poppins,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun DataUI() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 30.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$87.50 K",
                color = PrimaryGrey,
                fontFamily = poppins,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 20.sp
            )

            Text(
                text = "Total Income",
                color = PrimaryGrey,
                fontFamily = poppins,
                modifier = Modifier.alpha(0.6f),
                fontSize = 14.sp
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$12.80 K",
                color = PrimaryGrey,
                fontFamily = poppins,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 20.sp
            )

            Text(
                text = "Total Spent",
                color = PrimaryGrey,
                fontFamily = poppins,
                modifier = Modifier.alpha(0.6f),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun CardUI() {
    Card(
        backgroundColor = CardRed,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(160.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
            ) {
                Text(
                    text = "Balance",
                    color = Color.White,
                    modifier = Modifier
                        .alpha(0.6f),
                    fontFamily = poppins
                )

                Text(
                    text = "$28,067.57",
                    color = Color.White,
                    fontFamily = poppins,
                    fontSize = 30.sp
                )

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .clip(Shapes.large)
                        .border(width = 0.dp, color = Color.Transparent, shape = Shapes.large),
                    colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryGrey)
                ) {
                    Text(
                        text = "Withdraw",
                        color = Color.White,
                        fontFamily = poppins,
                        fontSize = 12.sp,
                        modifier = Modifier.align(alignment = CenterVertically)
                    )
                }
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_wallet),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .alpha(0.5f)
                    .size(70.dp)
                    .padding(top = 20.dp, start = 0.dp, end = 20.dp)
            )
        }
    }
}

@Composable
fun HeaderUI() {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 26.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
            Text(
                text = "Hi Kelvin",
                color = PrimaryGrey,
                modifier = Modifier.alpha(0.6f),
                fontSize = 16.sp,
                fontFamily = poppins
            )

            Text(
                text = "Welcome back",
                color = PrimaryGrey,
                fontSize = 20.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Bold
            )
        }

        Card(
            shape = CircleShape,
            elevation = 4.dp
        ) {
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .border(width = 0.dp, color = Color.Transparent, shape = Shapes.medium)
                    .clip(Shapes.medium)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun FinanceHomeScreenPreview() {
    RandomComposeTheme {
        FinanceHomeScreen()
    }
}