package com.cmps312.bankingapp.DAOS

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cmps312.bankingapp.models.Transaction

@Database(entities = [Transaction::class],version = 1, exportSchema = false)
abstract class TransactionDatabase: RoomDatabase(){

    abstract fun transactionDoa():TransactionDAO
    companion object{

        @Volatile
        private var database:TransactionDatabase?=null

        @Synchronized
        fun getDatabase(context: Context):TransactionDatabase{

            if (database==null){
                database= Room.databaseBuilder(context.applicationContext,TransactionDatabase::class.java,"Transaction_db")
                    .fallbackToDestructiveMigration().build()
            }

            return database as TransactionDatabase
        }


    }



}
