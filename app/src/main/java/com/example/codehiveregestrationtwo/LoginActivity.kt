package com.example.codehiveregestrationtwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.codehiveregestrationtwo.api.ApiClient
import com.example.codehiveregestrationtwo.api.ApiInterface
import com.example.codehiveregestrationtwo.module.Loginrequest
import com.example.codehiveregestrationtwo.module.Loginrespond
import com.example.codehiveregestrationtwo.module.Registrationrespond
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import java.util.*
import javax.security.auth.callback.Callback

class LoginActivity : AppCompatActivity() {
    lateinit var etemail: EditText
    lateinit var etpassword: EditText
    lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        castviews()



    }
    fun castviews() {
        etemail = findViewById(R.id.etemail)
        etpassword = findViewById(R.id.etpassword)
        btnLogin = findViewById(R.id.btnLogin)
       clicklogin()

    }
    fun clicklogin() {
        var error=false
        btnLogin.setOnClickListener {
            var email = etemail.text.toString()
            if (email.isEmpty()) {
                error=true
                etemail.setError("email is required")

            }
            var password = etpassword.toString()
            if (password.isEmpty()) {
                error=true
                etpassword.setError("Password is required")
            }
            var loginrequest = Loginrequest(
                email = email,
                password = password
            )


            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
            var request = retrofit.loginstudent(loginrequest)
            request.enqueue(object :retrofit2.Callback<Loginrespond> {
                override fun onResponse(call: Call<Loginrespond>, response: Response<Loginrespond>) {
                    if (response.isSuccessful){
                        Toast.makeText(baseContext, "login Successful", Toast.LENGTH_LONG).show()
                        var intent=Intent( baseContext,courseactivity::class.java)
                        startActivity(intent)
                    }

                    else{
                        try {
                            val error = JSONObject(response.errorBody()!!.string())
                            Toast.makeText(baseContext, error.toString(), Toast.LENGTH_LONG)
                                .show()
                        } catch (e: Exception) {
                            Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
                        }
                    }
                }

                override fun onFailure(call: Call<Loginrespond>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}










