package com.ddorocare.brand_audit

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ddorocare.brand_audit.model.RegisterRequest
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {
    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var name: TextInputEditText
    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var passwordCheck: TextInputEditText
    private lateinit var registerButton: MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        name = findViewById(R.id.edt_name)
        email = findViewById(R.id.edt_email)
        password = findViewById(R.id.edt_password)
        passwordCheck = findViewById(R.id.edt_confirm_password)
        registerButton = findViewById(R.id.btn_register)

        setupViewModel()
        setupAction()

    }

    private fun setupViewModel() {
        registerViewModel = ViewModelProvider(
            this
        )[RegisterViewModel::class.java]
    }

    private fun setupAction() {
        registerButton.setOnClickListener {
            val name = name.text.toString()
            val email = email.text.toString()
            val password = password.text.toString()
            val passwordCheck = passwordCheck.text.toString()


            registerViewModel.register(RegisterRequest(name,email, password, passwordCheck)).observe(this) { result ->
                if (result != null) {
                    when (result) {
                        is ResultCustom.Loading -> findViewById<ProgressBar>(R.id.pb_loading).visibility =
                            View.VISIBLE
                        is ResultCustom.Success -> {
                            val user = result.data
                            findViewById<ProgressBar>(R.id.pb_loading).visibility = View.GONE
                            finish()

                        }
                        is ResultCustom.Error -> {
                            findViewById<ProgressBar>(R.id.pb_loading).visibility = View.GONE
                            Toast.makeText(
                                this@RegisterActivity,
                                result.error,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }



}