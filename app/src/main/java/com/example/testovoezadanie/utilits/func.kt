package com.example.testovoezadanie.utilits

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.downloadAndSetImage(url: String){
    Glide.with(this)
        .load(url)
        .skipMemoryCache(false)
        .into(this)
}