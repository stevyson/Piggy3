package com.example.piggy.feature_expense.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Expense(
    val title: String,
    val amount: Float ,
    val timestamp: String,
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null

) : Parcelable
