package com.bullseye.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun  MyText(text:String,modifier: Modifier = Modifier, fontWeight: FontWeight = FontWeight.Normal,
            decoration: TextDecoration = TextDecoration.None,
size:TextUnit = 14.sp){
    Text(text = text, fontWeight = FontWeight.Bold,textDecoration = decoration,modifier= modifier,
        fontSize = size)
}

@Composable
fun MyTitleText(text: String, modifier: Modifier = Modifier){
    MyText(text = text,modifier, size = 24.sp)
}