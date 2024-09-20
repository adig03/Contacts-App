package com.example

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.room.Room
import com.example.ViewModels.ContactViewModel
import com.example.ViewModels.ContactViewModelFactory
import com.example.notestakingapp.R
import com.example.repository.ContactRepository
import com.example.room.ContactDAO
import com.example.room.ContactDB

class MainActivity : AppCompatActivity() {
     lateinit var contactViewModel: ContactViewModel

    private lateinit var navController: NavController
    lateinit var db: ContactDB
    lateinit var dao: ContactDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
         navController = navHostFragment.navController
        setUpViewModel()
        }
    private fun setUpViewModel() {
        // Create an instance of the Room database
        val contactDataBase = Room.databaseBuilder(
            application,  // Use application context
            ContactDB::class.java,   // The NoteDB class
            "contact_DataBase"      // The name of the database
        ).build()
        // Create an instance of the repository
        val ContactRepository= ContactRepository(contactDataBase)

        // Initialize the ViewModel with the repository
        val viewModelFactory = ContactViewModelFactory(application, ContactRepository)

        // Initialize the ViewModel using ViewModelProvider
        contactViewModel= ViewModelProvider(this, viewModelFactory)[ContactViewModel::class.java]
    }
}

