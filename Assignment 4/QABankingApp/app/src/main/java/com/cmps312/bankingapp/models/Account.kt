package com.cmps312.bankingapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Account(
    var name: String = "",
    var acctType: String = "",
    var balance: Double = 0.0,
    @PrimaryKey(autoGenerate = true)
    val accountNo:String="",
)