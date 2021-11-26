package com.example.barduck

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class SignInActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText









    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        email = findViewById((R.id.edTextMailEnter))
        password = findViewById(R.id.editTextTextPassword)
    }
    fun Login(view: android.view.View) {
        if (email.text.isNotEmpty() && password.text.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(
                email.text
            ).matches()
        ) {
            startActivity(Intent(this@SignInActivity, menuActivity::class.java))
            finish()

        } else {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Заполните все поля")
                .setPositiveButton("OK", null)
                .create()
                .show()
        }
    }
    fun signup(view: android.view.View) {
        val intent = Intent (this,SignUpActivity::class.java)
        startActivity(intent)
    }
}