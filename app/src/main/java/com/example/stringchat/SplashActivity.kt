package com.example.stringchat

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val prefs = getSharedPreferences("LoginData", MODE_PRIVATE)
        if(prefs.contains(EMAIL_KEY)){
            val emailValue = prefs.getString(EMAIL_KEY, "")
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra(EMAIL_KEY, emailValue)
            startActivity(intent)
        } else{
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
}