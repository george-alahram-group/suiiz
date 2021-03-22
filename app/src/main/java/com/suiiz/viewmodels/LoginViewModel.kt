package com.suiiz.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.suiiz.repositories.MainRepository

class LoginViewModelProviderFactory(
    val app: Application,
    val repository: MainRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(app, repository) as T
    }
}

class LoginViewModel(
    app: Application,
    val repository: MainRepository
) : AndroidViewModel(app) {

    // TODO : logic here

}

