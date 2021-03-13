package com.example.stringchat.db

import androidx.room.*
import com.example.stringchat.db.entities.User

@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Insert
    fun insertUsers(user: List<User>)

    @Query("select * from User where email =:email")
    fun doesEmailExist(email: String):User?

    @Query("select * from User where email =:email and password =:password")
    fun getUserForEmailAndPassword(email: String, password: String): User?

}