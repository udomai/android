package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrants()
                }
            }
        }
    }
}

@Composable
fun InfoCard(header: String, paragraph: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            //The order of background and padding matters!!
            .background(color)
            .padding(16.dp)
    ) {
        Text(
            text = header,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp) // This, I think, sets up a new value
        )
        Text(
            text = paragraph,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ComposeQuadrants() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            InfoCard(
                header = stringResource(R.string.x03_h1),
                paragraph = stringResource(R.string.x03_p1),
                color = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f))
            InfoCard(
                header = stringResource(R.string.x03_h2),
                paragraph = stringResource(R.string.x03_p2),
                color = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f))
        }
        Row(Modifier.weight(1f)) {
            InfoCard(
                header = stringResource(R.string.x03_h3),
                paragraph = stringResource(R.string.x03_p3),
                color = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f))
            InfoCard(
                header = stringResource(R.string.x03_h4),
                paragraph = stringResource(R.string.x03_p4),
                color = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantsPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrants()
    }
}