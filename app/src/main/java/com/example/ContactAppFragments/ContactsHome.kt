package com.example.ContactAppFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.Adapter.CustomAdapter
import com.example.MainActivity
import com.example.ViewModels.ContactViewModel
import com.example.notestakingapp.R
import com.example.notestakingapp.databinding.FragmentContactsHomeBinding


class ContactsHome : Fragment(R.layout.fragment_contacts_home),
    androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentContactsHomeBinding
    private lateinit var contactViewModel:ContactViewModel
    private lateinit var customAdapter: CustomAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contacts_home, container, false)
        return binding.root

        contactViewModel = (activity as MainActivity).contactViewModel

        customAdapter = CustomAdapter()









    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        TODO("Not yet implemented")
    }

    private fun setUpRecyclerView(){
        binding.recyclerViewContacts.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = customAdapter
        }

        contactViewModel.contacts.observe(viewLifecycleOwner, {contacts->
            customAdapter.differ.submitList(contacts)

        })
    }



}