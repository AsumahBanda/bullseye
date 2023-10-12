package com.bullseye.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bullseye.R
import com.bullseye.components.GameDetails
import com.bullseye.components.MyAlert
import com.bullseye.components.MyTitleText
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.random.Random

@Composable
fun GameScreen(
    modifier: Modifier = Modifier, navigateToAbout: () -> Unit,
) {
    Box {

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.background),
            contentDescription = "background image"
        )
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
        ) {
            var showAlert by remember {
                mutableStateOf(false)
            }

            fun genTarget() = Random.nextInt(1, 100)

            var targetValue by remember {
                mutableStateOf(genTarget())
            }
            var totalScore by remember {
                mutableStateOf(0)
            }

            var rounds by remember {
                mutableStateOf(1)
            }

            var sliderValue by remember {
                mutableStateOf(0.5f)
            }

            fun diff(): Int {
                return abs(targetValue - sliderValue).toInt()
            }

            fun currentScore(): Int {
                val maxScore = 10
                val diff = diff()

                Log.i("hello", diff.toString())
                if (diff == 0) return maxScore
                if (diff in 1..3) return maxScore - 5
                if (diff in 4..15) return maxScore - 8
                return 0

            }

            fun reset() {
                sliderValue = 50f
                targetValue = genTarget()
                rounds = 1
                totalScore = 0
                print("me")
            }

            fun alertMsg(): Int {
                val diff = diff()
                if (diff == 0) return R.string.alertMsg1
                if (diff in 1..15) return R.string.alertMsg2
                return R.string.alertMsg3
            }

            fun dismiss() {
                showAlert = false
                rounds++
                targetValue = genTarget()
            }
            MyTitleText(
                text = stringResource(R.string.instructions),
                modifier = Modifier.padding(30.dp)
            )
            MyTitleText(text = targetValue.toString(), modifier = Modifier.padding(top = 10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = stringResource(R.string.minSliderValue))
                Slider(
                    value = sliderValue,
                    valueRange = 0f..100f,

                    onValueChange = { value ->
                        sliderValue = value
                    },
                    modifier = modifier.weight(1f),

                    )
                Text(text = stringResource(R.string.maxSliderValue))
            }


            Button(
                onClick = {
                    showAlert = !showAlert
                    totalScore += currentScore()
                }) {
                Text(text = stringResource(R.string.clickMe))
            }

            GameDetails(
                totalScore, rounds = rounds, reset = { reset() },

                navigateToAbout
            )

            if (showAlert) MyAlert(title = stringResource(id = alertMsg()),
                content = stringResource(
                    R.string.alertMessage,
                    ceil(sliderValue).toInt(),
                    currentScore()
                ),
                onDismiss = { dismiss() })
        }
    }
}

