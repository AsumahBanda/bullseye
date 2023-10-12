package com.bullseye

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bullseye.screens.AboutScreen
import com.bullseye.screens.GameScreen
import com.bullseye.ui.theme.BullseyeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BullseyeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  MainScreen()
                }
            }
        }
    }
}


@Composable
fun MainScreen(){
val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "gamescreen"){
        composable(route = "gamescreen"){ GameScreen(navigateToAbout={
            navController.navigate("about")
        })}
        composable(route = "about"){ AboutScreen(
            backToHome= {
                navController.popBackStack()
            }
        )}
    }

}

@Preview(showBackground = true, widthDp = 814, heightDp = 412)
@Composable
fun GameScreenPreview() {
   MainScreen()
}
