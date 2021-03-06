package com.example.stringchat

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sign_in_button.setOnClickListener {
            val emailValue = email_address_field.text.toString()
            val passwordValue = password_field.text.toString()
            val isRememberMe = remember_me_switch.isChecked

            if(emailValue.isEmpty()){
                showAlertDialog("You have not entered Email")
                return@setOnClickListener
            }

            if(passwordValue.isEmpty()){
                showAlertDialog("You have not entered password")
                return@setOnClickListener
            }

            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra(EMAIL_KEY, emailValue)
            startActivity(intent)
        }

    }

    private fun showAlertDialog(message: String) {
        AlertDialog.Builder(this)
                .setTitle(R.string.login_alert)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok){
                    dialog, actionId ->
                }
                .show()
    }
}