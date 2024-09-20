package com.example.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ContactAppFragments.ContactsHomeDirections
import com.example.notestakingapp.databinding.ItemContactBinding
import com.example.room.Contact

class CustomAdapter():RecyclerView.Adapter<CustomAdapter.ContactViewHolder>(){
    class ContactViewHolder(val binding: ItemContactBinding):RecyclerView.ViewHolder(binding.root)

    private val differCallBack = object : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.contactId == newItem.contactId
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = differ.currentList[position]
        holder.binding.ContactName.text = currentContact.contactName
        holder.binding.ContactNumber.text = currentContact.contactPhone.toString()
        holder.binding.ContactImage.setImageResource(currentContact.contactImage!!)

        holder.itemView.setOnClickListener {
            // Use the callback to handle item clicks
            val direction = ContactsHomeDirections.actionContactsHomeToContactsUpdate(currentContact)

            it.findNavController().navigate(direction)
        }
    }
}