package com.example.stringchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.text.Html
import android.text.SpannableStringBuilder
import com.example.stringchat.db.UserDatabase
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val email = intent.getStringExtra(EMAIL_KEY)

        val database = UserDatabase.getInstance(this)
        val userDao = database.getUserDao()

        CoroutineScope(Dispatchers.IO).launch {
            val user = userDao.doesEmailExist(email ?: "")

            if (user != null) {
                withContext(Dispatchers.Main){
                    message_text.text = getString(R.string.home_user_message, user.firstName, user.email)
                }
            }
        }

        
        logout.setOnClickListener {
            val prefs = getSharedPreferences("LoginData", MODE_PRIVATE)
            prefs.edit()
                .remove(EMAIL_KEY)
                .apply()
            finish()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}