package com.bullseye.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun AboutScreen(backToHome:()->Unit) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(text = "About Page") },
                navigationIcon = {
                    IconButton(onClick = {backToHome() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Go back")
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,

                    )
            )
        }
    ) { paddingValues->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .consumeWindowInsets(paddingValues)
        ) {
            Text(
                text = "🎉 Bullseye 🎉",
                style = typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                modifier = Modifier.padding(16.dp),
                text = "This is Bullseye, the game where you can win points and earn fame by dragging a slider.\\nYour goal is to place the slider as close as possible to the target value. The closer you are, the more points you score.",
                textAlign = TextAlign.Center,
                style = typography.bodyLarge
            )
            Button(onClick = {backToHome() }) {
                Text(text = "Go back")
            }
        }

    }
}



@Preview(showBackground = true, device = Devices.AUTOMOTIVE_1024p, widthDp = 864, heightDp = 416)
@Composable
fun AboutScreenPreview() {
    AboutScreen(backToHome = {})
}