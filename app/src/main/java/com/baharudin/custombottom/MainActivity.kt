package com.baharudin.custombottom

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.baharudin.custombottom.ui.custom.CustomBottomNavigation
import com.baharudin.custombottom.ui.custom.Navigation
import com.baharudin.custombottom.ui.custom.Screen
import com.baharudin.custombottom.ui.theme.CustomBottomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = MaterialTheme.colors.background.toArgb()
            window.navigationBarColor = MaterialTheme.colors.background.toArgb()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                window.navigationBarDividerColor = MaterialTheme.colors.background.toArgb()
            }
            val currentScreen = remember{
                mutableStateOf<Screen>(Screen.Home)
            }
            val navController = rememberNavController()
            CustomBottomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        bottomBar = {
                            CustomBottomNavigation(
                                currentScreenId = currentScreen.value.id) {
                                currentScreen.value = it
                            }
                        }
                    ) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}
