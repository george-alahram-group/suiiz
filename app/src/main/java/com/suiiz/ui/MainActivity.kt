package com.suiiz.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.suiiz.R
import com.suiiz.repositories.MainRepository
import com.suiiz.viewmodels.MainViewModel
import com.suiiz.viewmodels.MainViewModelProviderFactory
import com.suiiz.viewmodels.VehicleViewModel
import com.suiiz.viewmodels.VehicleViewModelProviderFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    lateinit var vehicleViewModel: VehicleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = MainRepository()
        val viewModelFactory = MainViewModelProviderFactory(application,repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getSharedPrefLocale(this, this, resources)
        setTheme(R.style.Theme_Suiiz) /* we already set a theme as default and it change to this theme to work as splash screen when the screen comes ready */
        setContentView(R.layout.activity_main)

        val vehicleViewModelProviderFactory = VehicleViewModelProviderFactory(application,repository)
        vehicleViewModel = ViewModelProvider(this,vehicleViewModelProviderFactory).get(VehicleViewModel::class.java)

    }

}