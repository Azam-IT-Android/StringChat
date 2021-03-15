package com.example.stringchat.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @PrimaryKey(autoGenerate = true) var uid: Int,
    var email: String,
    var password: String,
    var firstName: String,
    var lastName: String,
    var age: Int
)