package com.example.m5_l2

import LoveModel
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.m5_l2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val api = RetrofitInstance.api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            api.getPercentage(
                firstName = binding.etFirstName.text.toString(),
                secondName = binding.etSecondName.text.toString(),
                key = "c732f0c4e3msh91a761a72200d2dp184bf2jsn54b4a6407fe2",
                host = "love-calculator.p.rapidapi.com"
            ).enqueue(object : retrofit2.Callback<LoveModel> {
                override fun onResponse(p0: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful && response.body() != null) {
                        val loveModel = response.body()!!
                        val intent = Intent(this@MainActivity, ResultActivity::class.java)
                        intent.putExtra("loveModel", loveModel)
                        startActivity(intent)
                    }
                }

                override fun onFailure(p0: Call<LoveModel>, thr: Throwable) {
                    Toast.makeText(this@MainActivity, thr.message, Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}
