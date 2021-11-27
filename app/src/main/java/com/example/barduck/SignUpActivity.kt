package com.example.barduck

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var phone: EditText
    lateinit var passwordRepeat: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        email = findViewById(R.id.edTextMail)
        password = findViewById(R.id.editTextTextPasswordReg)
        passwordRepeat = findViewById(R.id.editTextTextPasswordRegRepeat)
        phone = findViewById(R.id.editTextPhone)


    }

    fun reg(view: View){
        if (email.text.isNotEmpty() && email.text.isNotEmpty() && phone.text.isNotEmpty() && password.text.isNotEmpty() && passwordRepeat.text.isNotEmpty()) {
            if (password.text.toString() == passwordRepeat.text.toString()) {
                startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
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
   }
}