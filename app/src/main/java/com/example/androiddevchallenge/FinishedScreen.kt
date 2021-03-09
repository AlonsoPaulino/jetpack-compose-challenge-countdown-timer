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
fun FinishedScreen() {
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
            text = "Congrats!",
            style = typography.h3,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "You reached the end of this journey, come on and learn Compose together!",
            style = typography.body2,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            currentScreen.value = CountdownScreen.START
        }) {
            Text(text = "Click to restart the countdown")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Feel free to submit issues and PRs to this repo! \n\n By Alonso",
            style = typography.body2,
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun FinishScreenPreview() = FinishedScreen()