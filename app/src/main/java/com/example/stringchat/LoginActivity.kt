package com.example.stringchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sign_in_button.setOnClickListener {
            val emailValue = email_address_field.text.toString()
            val passwordValue = password_field.text.toString()

            val prefs = getSharedPreferences("LoginData", MODE_PRIVATE)
            prefs.edit()
                .putString(EMAIL_KEY, emailValue)
                .apply()

            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra(EMAIL_KEY, emailValue)
            startActivity(intent)
        }

    }
}