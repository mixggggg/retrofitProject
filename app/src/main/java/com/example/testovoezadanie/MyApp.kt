package com.example.testovoezadanie

import android.app.Application

class MyApp: Application() {

    private val typeface = TypefaseUtil()

    override fun onCreate() {
        super.onCreate()
        typeface.overrideFont(applicationContext, "SERIF", "font/sf_pro_display.otf")
    }
}