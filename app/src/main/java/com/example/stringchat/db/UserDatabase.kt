package com.example.stringchat.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.stringchat.db.entities.User

@Database(version = 1, entities = arrayOf(User::class))
abstract class UserDatabase: RoomDatabase() {

    abstract fun getUserDao():UserDao

    companion object{

        private var instance: UserDatabase? = null

        fun getInstance(context: Context):UserDatabase{
            if(instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
            }
            return instance!!
        }

    }

}