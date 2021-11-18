package com.cmps312.bankingapp.DAOS

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.cmps312.bankingapp.models.Transaction
@Dao
interface TransactionDAO {
    @Insert
    suspend fun insert(transaction: Transaction): Long
    @Update
    suspend fun update(transaction: Transaction)
    @Delete
    suspend fun delete(transaction: Transaction)
}