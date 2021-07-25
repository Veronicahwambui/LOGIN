package com.example.codehiveregestrationtwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.codehiveregestrationtwo.api.ApiClient
import com.example.codehiveregestrationtwo.api.ApiInterface
import com.example.codehiveregestrationtwo.module.Registrationrequest
import com.example.codehiveregestrationtwo.module.Registrationrespond
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etDob: EditText

    //    lateinit var etNationality:EditText
    lateinit var etEmail: EditText
    lateinit var etPhoneNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnRegister: Button
    lateinit var spNationality: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
        buttonListener()


    }

    fun castViews() {
        etName = findViewById(R.id.etName)
        etDob = findViewById(R.id.etDob)
//        etNationality= findViewById(R.id.etNationality)
        etEmail = findViewById(R.id.etEmail)
        etPhoneNumber= findViewById(R.id.etPhoneNumber)
        etPassword = findViewById(R.id.etPassword)
        btnRegister = findViewById(R.id.btnRegister)
        spNationality = findViewById(R.id.spNationality)

        val nationalities = arrayOf("Kenyan", "Rwandan", "Southsudanese", "Ugandan")
        val nationalityAdapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_item,
            nationalities
        )
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spNationality.adapter = nationalityAdapter


    }

    fun buttonListener() {
        var error=false
        btnRegister.setOnClickListener {
            var name = etName.text.toString()
            if (name.isEmpty()) {
               error=true
                etName.setError("name is required")

            }
            var date_of_birth = etDob.text.toString()
            if (date_of_birth.isEmpty()) {
                error=true
                etDob.setError("dob is required")
            }
            var natioanlity = spNationality.selectedItem.toString()
            var email = etEmail.text.toString()
            if(email.isEmpty()){
                error=true
                etEmail.setError("Email is required")
            }
            var password = etPassword.toString()
            if (password.isEmpty()){
                error=true
                etPassword.setError("Password is required")
            }
            var phone_number = etPhoneNumber.text.toString()
            if (phone_number.isEmpty()){
                error=true
                etPhoneNumber.setError("PhoneNumber is required")
            }

            var registrationrequest=Registrationrequest(
                name = name,
                phoneNumber=phone_number,
                email=email,
                nationality=natioanlity.toUpperCase(),
                dateOfBirth=date_of_birth,
                password= password



            )


            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
            var request = retrofit.registerstudent(registrationrequest)
            request.enqueue(object : Callback<Registrationrespond> {
                override fun onResponse(call: Call<Registrationrespond>, response: Response<Registrationrespond>) {
                    if (response.isSuccessful){
                        Toast.makeText(baseContext, "Registration Successful", Toast.LENGTH_LONG).show()
                        var intent=Intent(baseContext,LoginActivity::class.java)
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

                override fun onFailure(call: Call<Registrationrespond>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}





data class ApiError(var errors: List<String>)
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