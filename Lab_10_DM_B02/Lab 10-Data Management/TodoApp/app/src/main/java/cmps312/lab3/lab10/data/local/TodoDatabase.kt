package cmps312.lab3.lab10.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cmps312.lab3.lab10.data.local.entity.Project
import cmps312.lab3.lab10.data.local.entity.Todo

@Database(entities = [Todo::class, Project::class],version = 1, exportSchema = false)
abstract class TodoDatabase:RoomDatabase(){

    //inject the dao that you created
    abstract fun todoDao():TodoDao
    //companion object to craete a DB or to get the instance of the DB
    companion object{

        //we dont want oyr database to be cached, we want the users to always get the updated instance of the DB
        @Volatile
        private var database:TodoDatabase?=null

        //this protexts us from parallel transactions to avoid data inconsistency
        @Synchronized
        fun getDatabase(context: Context):TodoDatabase{

            if (database==null){
                database= Room.databaseBuilder(context.applicationContext,TodoDatabase::class.java,"todo_db")
                    .fallbackToDestructiveMigration().build()
            }

            return database as TodoDatabase
        }


    }



}