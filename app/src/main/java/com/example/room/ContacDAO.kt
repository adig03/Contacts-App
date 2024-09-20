package com.example.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(contact: Contact):Long
    @Delete
    suspend fun delete(contact: Contact)
    @Update
    suspend fun update(contact: Contact)

    @Query("SELECT * FROM Contact")
    fun getAllContactsInDB():LiveData<List<Contact>>

    @Query("SELECT * FROM Contact WHERE contactName LIKE :searchquery OR contactPhone LIKE :searchquery")
    fun searhContact(searchquery:String):LiveData<List<Contact>>



}