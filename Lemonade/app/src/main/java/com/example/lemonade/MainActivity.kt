package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeCycle(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0FCBB))
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonadeCycle(modifier: Modifier = Modifier) {

    var step by remember { mutableStateOf(0) }
    var neededSqueezes by remember { mutableStateOf(2) }
    var squeezes by remember { mutableStateOf(1) }

    val imageResource = when (step) {
        0 -> painterResource(R.drawable.lemon_tree)
        1 -> painterResource(R.drawable.lemon_squeeze)
        2 -> painterResource(R.drawable.lemon_drink)
        else -> painterResource(R.drawable.lemon_restart)
    }

    val imageDesc = when (step) {
        0 -> stringResource(R.string.lemon_tree_desc)
        1 -> stringResource(R.string.lemon_desc)
        2 -> stringResource(R.string.glass_full_desc)
        else -> stringResource(R.string.glass_empty_desc)
    }

    val userPrompt = when (step) {
        0 -> stringResource(R.string.lemon_tree)
        1 -> stringResource(R.string.lemon)
        2 -> stringResource(R.string.glass_full)
        else -> stringResource(R.string.glass_empty)
    }

    Column(
        modifier = modifier
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = imageResource,
            contentDescription = imageDesc,
            modifier = Modifier
                .clickable{
                    if(step == 2) {
                        step++
                    } else if(step == 0) {
                        neededSqueezes = (2..4).random()
                        squeezes = 1
                        step++
                    } else if(step == 3) {
                        step = 0
                    } else if (squeezes == 1) {
                        squeezes++
                    } else {
                        if(squeezes >= neededSqueezes) {
                            step++
                        } else {
                            // could've saved the third variable if instead we counted down neededSqueezes
                            squeezes++
                        }
                    }
                }
        )
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = userPrompt,
            fontSize = 18.sp
        )
    }
}