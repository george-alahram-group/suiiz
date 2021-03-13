package com.suiiz.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import com.suiiz.R
import com.suiiz.ui.fragments.LoginFragment
import com.suiiz.util.Constants
import com.suiiz.util.Constants.LANG
import com.suiiz.util.Constants.SHARED_PREF
import com.suiiz.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()
        viewModel.getSharedPrefLocale(this, this, resources)
        setTheme(R.style.Theme_Suiiz) /* we already set a theme as default and it change to this theme to work as splash screen when the screen comes ready */
        setContentView(R.layout.activity_main)



    }

}