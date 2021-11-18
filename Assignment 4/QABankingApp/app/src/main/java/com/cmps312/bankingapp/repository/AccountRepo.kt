package com.cmps312.bankingapp.repository

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.cmps312.bankingapp.DAOS.AccountDatabase
import com.cmps312.bankingapp.DAOS.TransactionDAO
import com.cmps312.bankingapp.DAOS.TransactionDatabase
import com.cmps312.bankingapp.common.generateRandomAccounts
import com.cmps312.bankingapp.models.Account
import com.cmps312.bankingapp.models.Transaction

/**
 * This class contains dummy data. It is your task to replace it with a room database
 */
class AccountRepo (private val context: Context){
    private val AccountDao by lazy{
        AccountDatabase.getDatabase(context).accountDoa()
    }
    private val TransactionDao by lazy{
        TransactionDatabase.getDatabase(context).transactionDoa()
    }
    suspend fun getAccounts(acctType:String)=AccountDao.getAccounts(acctType)
    suspend fun addAccount(account: Account)=AccountDao.insert(account)
    suspend fun deletAccount(account: Account)=AccountDao.delete(account)
    suspend fun updateAccount(accountNo: String, account: Account)=AccountDao.update(accountNo, account)
    suspend fun getAccount(aacountNo:String)=AccountDao.getAccount(aacountNo)
    suspend fun addTransaction(transaction: Transaction)=TransactionDao.insert(transaction)
}



