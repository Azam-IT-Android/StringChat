package com.example.stringchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import com.example.stringchat.db.UserDatabase
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val email = intent.getStringExtra(EMAIL_KEY)

        email_value.text = email

        val database = UserDatabase.getInstance(this)
        val userDao = database.getUserDao()

    }
}