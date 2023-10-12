package com.bullseye.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetails(totalScore:Int =0,
                rounds:Int = 1,reset:()->Unit,navigateToAbout:()->Unit){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement= Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
       FilledIconButton(
           colors = IconButtonDefaults.filledIconButtonColors(
              containerColor = MaterialTheme.colorScheme.tertiaryContainer
           ),
           onClick = { reset() },
       modifier = Modifier.size(50.dp)) {
        
           Icon( Icons.Filled.Refresh, contentDescription = "Reset",
           modifier = Modifier.padding(8.dp))

       }
        GameInfo(title = "Score ", value =totalScore )
        GameInfo(title = "Round ", value = rounds)
        FilledIconButton(onClick = { navigateToAbout() },
        modifier = Modifier.size(50.dp),
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer
        )) {
            Icon(Icons.Filled.Info, contentDescription ="Info page" )

        }
    }
}

@Composable
fun GameInfo(title:String, value:Int){
    Column(
        horizontalAlignment=Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        Text(text = title)
        Text(text = value.toString())
    }
}

