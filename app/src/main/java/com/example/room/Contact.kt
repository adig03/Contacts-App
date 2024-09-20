package com.example.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Entity
@Parcelize
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val contactId:Long,

    val contactName:String?,

    val contactPhone: Number?,

    val contactEmail: String?,

    val contactImage:Int?,

    val contactCompany:String?
):Parcelable
