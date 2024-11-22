package com.example.m5_l2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.m5_l2.databinding.ActivityMainBinding
import com.example.m5_l2.utils.focusAndClear
import com.example.m5_l2.utils.getTextName

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[LoveViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loveModel()
    }

    private fun loveModel() = with(binding) {
        viewModel.isProgressVisible.observe(this@MainActivity) {
            progressBar.isVisible = it
        }

        btnCalculate.setOnClickListener {
            viewModel.getPercentage(
                etFirstName.getTextName(),
                etSecondName.getTextName(),
                this@MainActivity,
                ResultActivity()
            )
            etFirstName.focusAndClear()
            etSecondName.focusAndClear()
        }
    }
}



