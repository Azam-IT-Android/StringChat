package com.example.stringchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val prefs = getSharedPreferences("LoginData", MODE_PRIVATE)
        if(prefs.contains(EMAIL_KEY)){
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra(EMAIL_KEY, prefs.getString(EMAIL_KEY, ""))
            startActivity(intent)
        } else{
            startActivity(Intent(this, LoginActivity::class.java))
        }

        finish()
    }
}