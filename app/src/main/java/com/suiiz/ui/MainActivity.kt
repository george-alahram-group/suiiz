package com.suiiz.ui

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.suiiz.R
import com.suiiz.util.Constants
import com.suiiz.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    // binding or synthetic
    private lateinit var viewModel: MainViewModel
    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Suiiz) /* we already set a theme as default and it change to this theme to work as splash screen when the screen comes ready */
        setContentView(R.layout.activity_main)

        // TODO : make shared pref for handle app language
        sharedPref = this.getSharedPreferences(Constants.SHARED_PREF,Context.MODE_PRIVATE)

        // view model implementation
        /*
        Repository Class initiate here
        View Model Provider Factory initiate here and its need the Repository
        */
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

}