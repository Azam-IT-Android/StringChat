package com.example.stringchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.stringchat.db.UserDatabase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sign_in_button.setOnClickListener {
            val emailValue = email_address_field.text.toString()
            val passwordValue = password_field.text.toString()

            val database = UserDatabase.getInstance(this)
            val dao = database.getUserDao()

            CoroutineScope(Dispatchers.IO).launch{
                val user = dao.getUserForEmailAndPassword(emailValue, passwordValue)
                if(user == null){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@LoginActivity, "Invalid username or password", Toast.LENGTH_SHORT).show()
                        return@withContext
                    }
                } else {
                    withContext(Dispatchers.Main){
                        val prefs = getSharedPreferences("LoginData", MODE_PRIVATE)
                        prefs.edit()
                            .putString(EMAIL_KEY, emailValue)
                            .apply()

                        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                        intent.putExtra(EMAIL_KEY, emailValue)
                        startActivity(intent)
                    }
                }
            }

        }

        register_text.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

    }
}