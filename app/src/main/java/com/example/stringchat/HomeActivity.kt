package com.example.stringchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                Toast.makeText(this, "Agreed to Terms and Conditions", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this, "Didn't Agree to Terms and Conditions", Toast.LENGTH_SHORT).show()
            }
        }

        maleButton.setOnCheckedChangeListener { buttonView, isChecked ->

        }
    }
}