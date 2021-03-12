package com.example.stringchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.stringchat.db.UserDao
import com.example.stringchat.db.UserDatabase
import com.example.stringchat.db.entities.User
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        sign_up_button.setOnClickListener {
            val emailValue = email_address_field.text.toString()
            val passwordValue = password_field.text.toString()
            val firstNameValue = first_name_field.text.toString()
            val lastNameValue = last_name_field.text.toString()

            if (emailValue.isEmpty()) {
                Toast.makeText(this, "Email is empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (passwordValue.isEmpty()) {
                Toast.makeText(this, "Password is empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (firstNameValue.isEmpty()) {
                Toast.makeText(this, "First name is empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (lastNameValue.isEmpty()) {
                Toast.makeText(this, "Last name is empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = User(
                0,
                emailValue,
                passwordValue,
                firstNameValue,
                lastNameValue
            )
            val database = UserDatabase.getInstance(this)
            val dao = database.getUserDao()

            CoroutineScope(Dispatchers.IO).launch {
                if (dao.doesEmailExist(user.email) != null) {
                    withContext(Main) {
                        Toast.makeText(
                            this@SignUpActivity,
                            "Email already exist!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    dao.insert(user)
                    withContext(Main){
                        finish()
                    }
                }
            }
        }
    }
}