package com.suiiz.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.suiiz.repositories.MainRepository

class RegisterViewModelProviderFactory(
    val app: Application,
    val repository: MainRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RegisterViewModel(app, repository) as T
    }
}

class RegisterViewModel(
    app: Application,
    val repository: MainRepository
) : AndroidViewModel(app) {

    // TODO : logic here

}

