package com.example.codehiveregestrationtwo

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.codehiveregestrationtwo.api.ApiClient
import com.example.codehiveregestrationtwo.api.ApiInterface
import com.example.codehiveregestrationtwo.databinding.ActivityLoginBinding
import com.example.codehiveregestrationtwo.databinding.ActivityMainBinding
import com.example.codehiveregestrationtwo.models.Registrationrequest
import com.example.codehiveregestrationtwo.models.Registrationrespond
import com.example.codehiveregestrationtwo.ui.courseactivity
import com.example.codehiveregestrationtwo.viewmodel.UserViewModel
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences=getSharedPreferences(Consants.SharedPreferences,Context.MODE_PRIVATE)
        redirect()
    }

    fun redirect(){
        var accesstoken=sharedPreferences.getString(Consants.ACCESS_TOKEN,Consants.EMPTY_STRING)
        if (accesstoken!!.isNotEmpty()){
            startActivity(Intent(baseContext, courseactivity::class.java))
        }else{
            startActivity(Intent(baseContext,LoginActivity::class.java))
        }
    }
    override fun onResume() {
        super.onResume()
        var intent = Intent(baseContext, LoginActivity::class.java)
        startActivity(intent)
        binding.btnRegister.setOnClickListener {
            var registrationRequest = Registrationrequest(
                name = binding.etName.text.toString(),
                phoneNumber = binding.etPhoneNumber.text.toString(),
                email = binding.etEmail.text.toString(),
                dateOfBirth = binding.etDob.text.toString(),
                password = binding.etPassword.text.toString(),
                nationality = binding.spNationality.selectedItem.toString(),
            )

            userViewModel.registerUser(registrationRequest)

        }
        userViewModel.registrationLiveData.observe(this
        ) { registrationResponse ->
            if (!registrationResponse.studentId.isNullOrEmpty()) {
                var intent = Intent(baseContext, LoginActivity::class.java)
                startActivity(intent)
                Toast.makeText(baseContext, "Registration Successful", Toast.LENGTH_LONG).show()
            }
        }
        val observe = userViewModel.registrationFailedLiveData.observe(this) { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        }
    }
     }

data class ApiError(var errors:List<String>)





//            var retrofit= ApiClient.buildApiClient(ApiInterface::class.java)
//            var request=retrofit.registerstudent(registrationrequest)
//            request.enqueue(object :Callback<Registrationrespond>{
//                override fun onResponse(
//                    call: Call<Registrationrespond>,
//                    response: Response<Registrationrespond>
//
//                ) {
//                    if(response.isSuccessful)
//                    Toast.makeText(baseContext,registrationrequest.toString(),Toast.LENGTH_LONG)
//
//                }
//
//                override fun onFailure(call: Call<Registrationrespond>, t: Throwable) {
//
//                }
//
//
//
//
//                })
//
//            }

//
//           Toast.makeText(baseContext, name, Toast.LENGTH_LONG).show()
//            var details = Details(
//                name = name,
//                dob = dob,
//                nationality = natioanlity,
//                PhoneNumber = phoneNumber,
//                Password= password,
//                Email= email
//            )

//            Toast.makeText(baseContext, details.toString(), Toast.LENGTH_LONG).show()
//            val intent = Intent(baseContext, courseactivity::class.java)
//            startActivity(intent)
//
//        }




//data class Details(var name:String,var dob:String,var nationality:String,var PhoneNumber:String,var Email:String,var Password:String)