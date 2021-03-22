package com.suiiz.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.findFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.suiiz.R
import com.suiiz.repositories.MainRepository
import com.suiiz.ui.fragments.LoginFragment
import com.suiiz.util.Constants
import com.suiiz.util.Constants.LANG
import com.suiiz.util.Constants.SHARED_PREF
import com.suiiz.viewmodels.MainViewModel
import com.suiiz.viewmodels.MainViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = MainRepository()
        val viewModelFactory = MainViewModelProviderFactory(application,repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getSharedPrefLocale(this, this, resources)
        setTheme(R.style.Theme_Suiiz) /* we already set a theme as default and it change to this theme to work as splash screen when the screen comes ready */
        setContentView(R.layout.activity_main)

        // bottomNavBar.setupWithNavController(navHostFragment.findNavController())

    }

}