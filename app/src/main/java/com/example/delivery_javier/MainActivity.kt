package com.example.delivery_javier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.delivery_javier.databinding.ActivityMainBinding
import android.os.Bundle
import com.example.delivery_javier.interface_user.Principal


class MainActivity : AppCompatActivity() {

    private lateinit var views: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityMainBinding.inflate(layoutInflater)
        setContentView(views.root)
        initializacionListeners()
    }

    private fun initializacionListeners() {
        views.Login.setOnClickListener {
            val userText = views.User.text.toString()
            val passwordText = views.Password.text.toString()

            userText?.let {
                passwordText?.let { itp ->
                    if (it.equals("jav_ayora") && itp.equals("123456")) {
                        goToPrincipal(userText)
                    }
                }
            }
        }
    }

    private fun goToPrincipal(userText:String) {
        var intent: Intent = Intent( this, Principal::class.java)
        intent.putExtra("name_user", userText)
        startActivity(intent)
    }
}