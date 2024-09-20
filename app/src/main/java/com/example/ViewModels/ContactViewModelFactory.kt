package com.example.ViewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.repository.ContactRepository

class ContactViewModelFactory(private val app:Application , private val repository: ContactRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ContactViewModel(app , repository) as T
    }
}