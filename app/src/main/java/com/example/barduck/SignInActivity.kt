package com.example.barduck

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        email = findViewById((R.id.edTextMailEnter))
        password = findViewById(R.id.editTextTextPassword)



            }
            fun signup(view: android.view.View) {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)


                fun Login(view: android.view.View) {

                    if (email.text.isNotEmpty() && password.text.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(
                            email.text
                        ).matches()
                    ) {
                        val retrofit = MyRetrofit().getRetrofit().create(RetApi::class.java)
                        val log = MyRetrofit().getRetrofit()
                        val getApi = log.create(RetApi::class.java)
                        var hashMap: HashMap<String, String> = HashMap<String, String>()
                        hashMap.put("email", email.text.toString())
                        hashMap.put("password", password.text.toString())
                        val log_call: retrofit2.Call<Login> = getApi.login(hashMap)


                        log_call.enqueue(object : retrofit2.Callback<Login> {
                            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                                if (response.body() != null) {

                                    startActivity(Intent(this@SignInActivity, menuActivity::class.java))
                                    finish()


                                } else AlertDialog.Builder(this@SignInActivity)
                                    .setMessage("Неверные данные входа").create().show()
                            }

                            override fun onFailure(call: Call<Login>, t: Throwable) {
                                val toast =
                                    Toast.makeText(
                                        this@SignInActivity,
                                        t.message,
                                        Toast.LENGTH_LONG
                                    ).show()


                            }
                        })
                    }

                else{
                    val alert = AlertDialog.Builder(this)
                        .setTitle("Ошибка")
                        .setMessage("Заполните все поля")
                        .setPositiveButton("ОК", null)
                    }
                }

            }


    }

