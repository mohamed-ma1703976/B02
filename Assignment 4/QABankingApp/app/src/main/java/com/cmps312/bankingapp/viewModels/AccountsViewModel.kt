package com.cmps312.bankingapp.viewModels

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.cmps312.bankingapp.common.generateRandomAccounts
import com.cmps312.bankingapp.models.Account
import com.cmps312.bankingapp.models.Transaction
import com.cmps312.bankingapp.repository.AccountRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountsViewModel(appContext: Application) :  AndroidViewModel(appContext) {
    var selectedAccount by mutableStateOf(Account())
    var accounts by mutableStateOf(mutableStateListOf<Account>().toTypedArray().toList())
    var currentFilter by mutableStateOf("All")
    private val accountRepository = AccountRepo(appContext)


    init {
        accounts = generateRandomAccounts()
    }

    //Todo Update this method, and connect it to the accountRepo
    fun getAccounts(acctType: String) = if (acctType == "All") accounts else
        liveData {
            emit(accountRepository.getAccounts(acctType))
        }

    //Todo Update this method, and connect it to the accountRepo
    fun getAccount(accountNo: String) = liveData {
        emit(accountRepository.getAccount(accountNo))


        //Todo Update this method, this was done just to help you with the design
        fun addAccount(account: Account) = viewModelScope.launch(Dispatchers.IO) {
            accountRepository.addAccount(account)

            //Todo Update this method, this was done just to help you with the design
            fun editAccount(accountNo: String, account: Account) =
                viewModelScope.launch(Dispatchers.IO) {
                    accountRepository.updateAccount(accountNo, account)


                    //Todo Update this method, this was done just to help you with the design
                    fun addTransaction(transaction: Transaction) =
                        viewModelScope.launch(Dispatchers.IO) {
                            accountRepository.addTransaction(transaction)


                            //Todo Update this method, this was done just to help you with the design
                            @RequiresApi(Build.VERSION_CODES.N)
                            fun deleteAccount(account: Account) =
                                viewModelScope.launch(Dispatchers.IO) {
                                    accountRepository.deletAccount(account)
                                }
                        }
                }
        }
    }
}
