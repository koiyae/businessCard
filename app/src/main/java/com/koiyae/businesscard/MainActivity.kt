package com.koiyae.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.koiyae.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFCFE8D2)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(R.drawable.android_logo)
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = modifier
                .size(150.dp)
                .background(color = Color(0xFF18293E)),
        ) {
            Image(painter = image, contentDescription = "android logo")
        }
        Text(
            text = stringResource(R.string.nome),
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Light
            )
        )
        Text(
            text = stringResource(R.string.role),
            style = TextStyle(
                color = Color(0xFF092A02),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Foot()
    }
}

@Composable
fun Foot(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(modifier = modifier) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = "phone number",
                tint = Color(0xFF104305)
            )
            Text(
                text = stringResource(R.string.number),
                modifier = modifier
                    .padding(
                        start = 15.dp,
                        bottom = 15.dp
                    )
            )
        }
        Row(modifier = modifier) {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "social media",
                tint = Color(0xFF104305)
            )
            Text(
                text = "@AndroidDev",
                modifier = modifier
                    .padding(
                        start = 15.dp,
                        bottom = 15.dp
                    )
            )
        }
        Row(modifier = modifier) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "email",
                tint = Color(0xFF104305)
            )
            Text(
                text = stringResource(R.string.email),
                modifier = modifier
                    .padding(
                        start = 15.dp,
                        bottom = 40.dp
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}