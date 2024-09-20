package com.example.repository

import androidx.lifecycle.LiveData
import androidx.room.Insert
import com.example.room.Contact
import com.example.room.ContactDB

class ContactRepository(private val ContactDB:ContactDB) {

    val Contacts = ContactDB.getDao().getAllContactsInDB()

   suspend fun insertContact(Contact:Contact):Long{
       return ContactDB.getDao().insert(Contact)
   }

    suspend fun updateContact(Contact: Contact){
        ContactDB.getDao().update(Contact)
    }
    suspend fun deleteContact(Contact: Contact){
        ContactDB.getDao().delete(Contact)
    }
    fun searchNote(searchquery: String): LiveData<List<Contact>> {
        return ContactDB.getDao().searhContact(searchquery)
    }




}