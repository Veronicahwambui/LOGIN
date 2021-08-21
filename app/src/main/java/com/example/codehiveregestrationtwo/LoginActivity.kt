package com.example.codehiveregestrationtwo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.codehiveregestrationtwo.databinding.ActivityLoginBinding
import com.example.codehiveregestrationtwo.models.Loginrequest
import com.example.codehiveregestrationtwo.ui.courseactivity
import com.example.codehiveregestrationtwo.viewmodel.loginViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences
    val loginViewModel:loginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

      sharedPreferences=getSharedPreferences("CODEHIVE_REG_PREF",Context.MODE_PRIVATE)

     var error=true
      binding.btnLogin.setOnClickListener {

            var email = binding.etemail.text.toString()
           error=true
            if (email.isEmpty()) {
                binding.etemail.setError("Email Required")

            }
            var password = binding.etpassword.text.toString()
           error=true
            if (password.isEmpty()) {
                binding.etpassword.setError("Password is required")
            }
            var loginrequest = Loginrequest(
                email = email,
                password = password
            )
          loginViewModel.login(loginrequest)
          binding.btnLogin.visibility=View.VISIBLE
        }

//        binding.btnLogin.setOnClickListener {
//            startActivity(intent(baseContext))
//        }

        }
    override fun onResume() {
        super.onResume()
        binding.tvloginError.visibility=View.GONE

        loginViewModel.loginLiveData.observe(this, { loginResponse ->
            binding.Pblogin.visibility=View.GONE
            Toast.makeText(baseContext, loginResponse.message, Toast.LENGTH_LONG).show()

            var editor=sharedPreferences.edit()
            editor.putString("ACCESS_TOKEN",loginResponse.accessToken)
            editor.putString("STUDENT_ID",loginResponse.accessToken)
            editor.apply()

//            sharedPreferences.edit().putString("ACCESS_TOKEN",loginResponse.accessToken).apply()
//            var x = sharedPreferences.getString("ACCESS_TOKEN", "")
            startActivity(Intent(baseContext, courseactivity::class.java))

        })
        loginViewModel.loginFailedLiveData.observe(this) { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
            binding.Pblogin.visibility=View.GONE
            binding.tvloginError.visibility=View.VISIBLE
            binding.tvloginError.text=error
        }
    }
}








