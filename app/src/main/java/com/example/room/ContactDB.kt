package com.example.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class] , version = 1)
abstract class ContactDB: RoomDatabase() {

    abstract fun getDao(): ContactDAO

    companion object {

        @Volatile
        var INSTANCE: ContactDB? = null

        fun getInstance(context: Context): ContactDB? {

            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext ,
                        ContactDB::class.java,
                        "ContactDataBase"
                    ).build()
                }

                    INSTANCE = instance
                return instance

            }

        }


    }
}
