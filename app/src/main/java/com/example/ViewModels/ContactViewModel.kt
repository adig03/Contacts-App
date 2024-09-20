package com.example.ViewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.example.repository.ContactRepository
import com.example.room.Contact
import kotlinx.coroutines.launch

class ContactViewModel(private val app:Application , private val repository:ContactRepository):ViewModel() {

    val contacts = repository.Contacts

    fun addContact(contact: Contact) = viewModelScope.launch {
        repository.insertContact(contact)
    }

    fun deleteContact(contact: Contact) = viewModelScope.launch {
        repository.deleteContact(contact)
    }

    fun updateContact(contact: Contact) = viewModelScope.launch{
        repository.updateContact(contact)
    }

    fun searchContact(query: String) = viewModelScope.launch {
        repository.searchNote(query)
    }

}
