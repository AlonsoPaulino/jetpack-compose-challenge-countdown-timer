package com.example.androiddevchallenge

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CountingDownScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Button(onClick = {
            currentScreen.value = CountdownScreen.FINISHED
        }) {
            Text(text = "Click to finish the countdown")
        }
    }
}

@Preview
@Composable
private fun CountDownPreview() = CountingDownScreen()