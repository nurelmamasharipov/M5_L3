package com.example.m5_l2.ui

import android.annotation.SuppressLint
import com.example.m5_l2.data.LoveModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.m5_l2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityResultBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loveDataObserve()
        binding.btnTryAgain.setOnClickListener {
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    fun loveDataObserve() = with(binding) {
        val data = intent.getSerializableExtra(ARG_LOVE_MODEL_KEY) as LoveModel
        tvFirstName.text = data.firstName
        tvSecondName.text = data.secondName
        tvPercent.text = "${data.percentage}%"
        tvScore.text = data.result
    }

    companion object {
        const val ARG_LOVE_MODEL_KEY = "love_model_key"
    }
}