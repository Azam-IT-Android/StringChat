package com.example.stringchat

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login_form.*

class LoginFormFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sign_in_button.setOnClickListener {
            val emailValue = email_address_field.text.toString()
            val passwordValue = password_field.text.toString()

            val intent = Intent(context, HomeActivity::class.java)
            intent.putExtra(EMAIL_KEY, emailValue)
            startActivity(intent)
        }
    }

}