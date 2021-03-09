package com.example.androiddevchallenge

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StartScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        val typography = MaterialTheme.typography

        Text(
            text = "$COUNTDOWN_TIME_SECONDS seconds countdown!",
            style = typography.h3,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            counter.value = COUNTDOWN_TIME_SECONDS
            currentScreen.value = CountdownScreen.COUNTING_DOWN
        }) {
            Text(text = "Click here to start the countdown")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "For now you can only countdown $COUNTDOWN_TIME_SECONDS seconds \n Sorry for that, " +
                    "I am newbie with Compose, but next time it will be " +
                    "customizable enough!. \n\n By Alonso",
            style = typography.body2,
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun StartScreenPreview() = StartScreen()