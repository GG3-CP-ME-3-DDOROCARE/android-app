package com.ddorocare.brand_audit

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ddorocare.brand_audit.model.LoginRequest
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class LoginActivity : AppCompatActivity() {
    //    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var loginButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)
        email = findViewById(R.id.edt_email)
        password = findViewById(R.id.edt_password)
        loginButton = findViewById(R.id.btn_login)

//        setMyButtonEnable()
//        validationEditText()
        setupViewModel()
        setupAction()

    }

    private fun setMyButtonEnable() {
        val email = email.text.toString().trim()
        val password = password.text.toString().trim()
        loginButton.isEnabled =
            email.isNotEmpty() && isEmailValid(email) && password.length > 0 && password.isNotEmpty()
    }

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    private fun validationEditText() {
        email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {
            }
        })
    }

    private fun setupViewModel() {
        loginViewModel = ViewModelProvider(
            this
        )[LoginViewModel::class.java]
    }

    private fun setupAction() {
        loginButton.setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()

            loginViewModel.login(LoginRequest(email, password)).observe(this) { result ->
                if (result != null) {
                    when (result) {
                        is ResultCustom.Loading -> findViewById<ProgressBar>(R.id.pb_loading).visibility =
                            View.VISIBLE
                        is ResultCustom.Success -> {
                            val user = result.data
                            findViewById<ProgressBar>(R.id.pb_loading).visibility = View.GONE
//                            loginViewModel.saveLogin(user.token)
                            AlertDialog.Builder(this).apply {
                                setTitle("Yeah!")
                                setMessage("Anda berhasil login")
                                setPositiveButton("Lanjut") { _, _ ->
                                    val intent = Intent(context, MainActivity::class.java)
//                                    intent.putExtra(MainActivity.ID_USER, result.data.token)
                                    intent.flags =
                                        Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                                    startActivity(intent)
                                    finish()
                                }
                                create()
                                show()
                            }
                        }
                        is ResultCustom.Error -> {
                            findViewById<ProgressBar>(R.id.pb_loading).visibility = View.GONE
                            Toast.makeText(
                                this@LoginActivity,
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
