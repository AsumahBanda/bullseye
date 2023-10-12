package com.bullseye.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.bullseye.R


@Composable
fun MyAlert(title:String,content:String, onDismiss:()->Unit){
    AlertDialog(onDismissRequest = { onDismiss() },
        confirmButton =
        {
            Button(onClick = { onDismiss() }) {
                Text(text = stringResource(R.string.ok))
            }
        },
        text = {
            MyText(text = content)
        }, title = {
            MyText(text = title)

        })
}