package com.example.m5_l2.ui

import com.example.m5_l2.data.LoveModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.m5_l2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private val binding by lazy { ActivityResultBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnTryAgain.setOnClickListener {
            finish()
        }

        val loveModel = intent.getSerializableExtra("loveModel") as LoveModel
            binding.tvFirstName.text = loveModel.firstName
            binding.tvSecondName.text = loveModel.secondName
            binding.tvPercent.text = "${loveModel.percentage}%"
            binding.tvScore.text = loveModel.result
    }
}