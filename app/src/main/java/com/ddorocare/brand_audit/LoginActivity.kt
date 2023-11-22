package com.ddorocare.brand_audit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.ddorocare.brand_audit.model.LoginRequest
import com.ddorocare.brand_audit.model.UserModel
import com.ddorocare.brand_audit.model.UserPreference
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class LoginActivity : AppCompatActivity() {
    //    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var loginButton: MaterialButton
    private lateinit var registerButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)
        email = findViewById(R.id.edt_email)
        password = findViewById(R.id.edt_password)
        loginButton = findViewById(R.id.btn_login)
        registerButton = findViewById(R.id.btn_register)
        setupViewModel()
        setupAction()




        registerButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }


    private fun setupViewModel() {
        loginViewModel = ViewModelProvider(
            this,
            ViewModelFactory(UserPreference.getInstance(dataStore))
        )[LoginViewModel::class.java]

        loginViewModel.logout()
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
                            loginViewModel.saveLogin(user.token)
                            loginViewModel.saveUser(
                                UserModel(
                                    result.data.token,
                                    result.data.fullName!!,
                                    result.data.username!!,
                                    true,
                                    role = result.data.role!!
                                )
                            )
                            AlertDialog.Builder(this).apply {
                                val intent = Intent(context, MainActivity::class.java)
                                intent.putExtra("name", result.data.fullName)
                                intent.putExtra("role", result.data.role)
                                Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                                startActivity(intent)
                                finish()
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
