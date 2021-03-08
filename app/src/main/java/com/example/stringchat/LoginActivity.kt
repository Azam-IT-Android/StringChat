package com.example.stringchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LoginActivityTag", "onCreate")
        setContentView(R.layout.activity_login)

        sign_in_button.setOnClickListener {
            val emailValue = email_address_field.text.toString()
            val passwordValue = password_field.text.toString()

            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra(EMAIL_KEY, emailValue)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        Log.d("LoginActivityTag", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LoginActivityTag", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LoginActivityTag", "onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.d("LoginActivityTag", "onStart")
    }

    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        super.onActivityReenter(resultCode, data)
        Log.d("LoginActivityTag", "onActivityReenter($resultCode)")
    }



    override fun onDestroy() {
        super.onDestroy()
        Log.d("LoginActivityTag", "onDestroy")
    }
}