package com.example.codehiveregestrationtwo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.codehiveregestrationtwo.api.ApiClient
import com.example.codehiveregestrationtwo.api.ApiInterface
import com.example.codehiveregestrationtwo.databinding.ActivityCourseactivityBinding
import com.example.codehiveregestrationtwo.databinding.ActivityLoginBinding
import com.example.codehiveregestrationtwo.databinding.ActivityMainBinding
import com.example.codehiveregestrationtwo.models.Loginrequest
import com.example.codehiveregestrationtwo.models.Loginrespond
import com.example.codehiveregestrationtwo.viewmodel.loginViewModel
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences
    val loginViewModel:loginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

      sharedPreferences=getSharedPreferences("CODEHIVE_REG_PREF",Context.MODE_PRIVATE)
      binding.btnLogin.setOnClickListener {

            var email = binding.etemail.toString()
            if (email.isEmpty()) {
                binding.etemail.setError("Email Required")


            }
            var password = binding.etpassword.toString()
            if (password.isEmpty()) {
                binding.etpassword.setError("Password is required")
            }
            var loginrequest = Loginrequest(
                email = email,
                password = password
            )
          loginViewModel.login(loginrequest)
        }

        }
    override fun onResume() {
        super.onResume()
        loginViewModel.loginLiveData.observe(this, { loginResponse ->
            Toast.makeText(baseContext, loginResponse.message, Toast.LENGTH_LONG).show()
            var accessToken = loginResponse.accessToken
            sharedPreferences.edit().putString("ACCESS_TOKEN", accessToken).apply()
            var x = sharedPreferences.getString("ACCESS_TOKEN", "")

        })
        loginViewModel.loginFailedLiveData.observe(this) { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        }
    }
}










