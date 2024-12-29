package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinesscardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinesscardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardComposer("Creature NEU", "Tally Creature", "+123 456 78 90 12 34", "creach@tallycreatures.com")
                }
            }
        }
    }
}

@Composable
fun CardComposer(name: String, occupation: String, phone: String, email: String, modifier: Modifier = Modifier) {
    val backgroundColor = Color(0xFF1A6B1A)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.bc_photo),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            Text(
                text = name,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 10.dp)
            )
            Text(
                text = occupation,
                fontStyle = FontStyle.Italic,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
        }
        Column(
            Modifier
                .padding(bottom = 200.dp)
                .weight(1f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row() {
                Image(
                    painterResource(R.drawable.bc_phone),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp))
                Text(
                    text = phone,
                    fontSize = 24.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
            Row() {
                Image(
                    painterResource(R.drawable.bc_email),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp))
                Text(
                    text = email,
                    fontSize = 20.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardComposerPreview() {
    BusinesscardTheme {
        CardComposer("Creature NEU", "Tally Creature", "+123 456 78 90 12 34", "creach@tallycreatures.com")
    }
}