package com.suiiz.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.suiiz.R

class MainActivity : AppCompatActivity() {

    // binding or synthetic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Suiiz)
        setContentView(R.layout.activity_main)



    }

}