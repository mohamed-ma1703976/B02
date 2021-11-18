package cmps312.lab3.authormanagement.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [/* add entities here*/], version = 2, exportSchema = false)
abstract class AuthorDatabase : RoomDatabase() {


    abstract fun authorDao(): AuthorDao



    companion object {
        @Volatile
        private var database: AuthorDatabase? = null


        @Synchronized
        fun getDatabase(context: Context): AuthorDatabase {
            if (database == null) {
                database = Room.databaseBuilder(context.applicationContext,
                    AuthorDatabase::class.java,
                    "author_db")
                    .fallbackToDestructiveMigration().build()
            }
            return database as AuthorDatabase
        }
    }
}