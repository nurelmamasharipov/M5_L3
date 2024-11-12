package com.example.m5_l2

import LoveModel
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.m5_l2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    val binding by lazy { ActivityResultBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val loveModel = intent.getSerializableExtra("loveModel") as LoveModel
        if (loveModel != null){
            binding.tvFirstName.text = loveModel.firstName
            binding.tvSecondName.text = loveModel.secondName
            binding.tvPercent.text = loveModel.percentage
            binding.tvScore.text = loveModel.result
        }
    }
}