package com.example.testovoezadanie

import android.content.Context
import android.graphics.Typeface

class TypefaseUtil {

    fun overrideFont(context: Context, defaultFontNameToOverride: String, customFontNameInAssets: String){

        try {
            val customFontTypeface = Typeface.createFromAsset(context.assets, customFontNameInAssets)
            val defaultFontTypefaceField = Typeface::class.java.getDeclaredField(defaultFontNameToOverride)

            defaultFontTypefaceField.setAccessible(true)

            defaultFontTypefaceField.set(null, customFontTypeface)
        }catch (e:Exception){

        }
    }
}