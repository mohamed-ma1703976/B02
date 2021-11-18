package com.cmps312.bankingapp.DAOS

import AccountDAO
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cmps312.bankingapp.models.Account

@Database(entities = [Account::class],version = 1, exportSchema = false)
abstract class AccountDatabase: RoomDatabase(){

        abstract fun accountDoa():AccountDAO
        companion object{

            @Volatile
            private var database:AccountDatabase?=null

            @Synchronized
            fun getDatabase(context: Context):AccountDatabase{

                if (database==null){
                    database= Room.databaseBuilder(context.applicationContext,AccountDatabase::class.java,"Account_db")
                        .fallbackToDestructiveMigration().build()
                }

                return database as AccountDatabase
            }


        }



    }
