package com.example.safezone

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Annotate application class with HiltAndroidApp
@HiltAndroidApp
class SafeZoneApplication : Application() {
    //no code -> annotation does the work
}