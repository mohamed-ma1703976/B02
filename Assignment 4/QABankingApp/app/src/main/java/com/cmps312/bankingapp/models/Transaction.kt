package com.cmps312.bankingapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity
class Transaction(
    var type: String,
    var amount: Double,
    var accountNo: String,
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
)
