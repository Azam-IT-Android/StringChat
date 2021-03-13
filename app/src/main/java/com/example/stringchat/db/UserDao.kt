package com.example.stringchat.db

import androidx.room.*
import com.example.stringchat.db.entities.User

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Insert
    suspend fun insertUsers(user: List<User>)

    @Query("select * from User where email =:email")
    suspend fun doesEmailExist(email: String):User?

    @Query("select * from User where email =:email and password =:password")
    suspend fun getUserForEmailAndPassword(email: String, password: String): User?

}