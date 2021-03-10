package com.example.stringchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navController = fragment4.findNavController()

        fragment1.setOnClickListener {
            navController.navigate(R.id.page1Fragment)
        }

        fragment2.setOnClickListener {
            navController.navigate(R.id.page2Fragment)
        }

        fragment3.setOnClickListener {
            navController.navigate(R.id.page3Fragment)
        }
    }
}