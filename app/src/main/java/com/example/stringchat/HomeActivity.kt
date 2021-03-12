package com.example.stringchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val email = intent.getStringExtra(EMAIL_KEY)

        email_value.text = email

        logoutButton.setOnClickListener {
            val prefs = getSharedPreferences("LoginData", MODE_PRIVATE)
            prefs.edit()
                    .remove(EMAIL_KEY)
                    .apply()
        }
    }
}