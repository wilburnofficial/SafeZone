package com.example.safezone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.safezone.navigation.AppStructure
import com.example.safezone.ui.theme.SafeZoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SafeZoneTheme {
                AppStructure()
            }
        }
    }
}
