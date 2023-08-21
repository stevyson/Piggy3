package com.example.piggy.feature_expense.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class User(
    val name: String,
    val occupation: String,
    @PrimaryKey(autoGenerate = true)
    val id : Int?
) : Parcelable
