/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CountingDownScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        val typography = MaterialTheme.typography

        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "${counter.value}",
                textAlign = TextAlign.Center,
                style = typography.h1,
                fontFamily = FontFamily.SansSerif,
            )

            val stroke = with(LocalDensity.current) {
                Stroke(5.dp.toPx())
            }

            val clockModifier = Modifier.size(320.dp)
            val angleOffset = 360f / COUNTDOWN_TIME_SECONDS

            Canvas(clockModifier) {
                val innerRadius = (size.minDimension - stroke.width) / 2
                val halfSize = size / 2.0f
                val topLeft = Offset(
                    halfSize.width - innerRadius,
                    halfSize.height - innerRadius
                )
                val size = Size(innerRadius * 2, innerRadius * 2)
                val startAngle = -90f
                val sweep = counter.value * angleOffset
                drawArc(
                    color = Color.Blue,
                    startAngle = startAngle,
                    sweepAngle = sweep,
                    topLeft = topLeft,
                    size = size,
                    useCenter = false,
                    style = stroke
                )
            }
        }

        Clock()
    }
}

@Composable
fun Clock() {
    val scope = rememberCoroutineScope()
    scope.launch {
        while (counter.value > 0) {
            delay(1000L)
            counter.value = counter.value - 1
        }
        currentScreen.value = CountdownScreen.FINISHED
    }
}

@Preview
@Composable
private fun CountDownPreview() = CountingDownScreen()
