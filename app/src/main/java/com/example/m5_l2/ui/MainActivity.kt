package com.example.m5_l2.ui

import com.example.m5_l2.data.LoveModel
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.m5_l2.data.RetrofitInstance
import com.example.m5_l2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainContract.View {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = MainPresenter(this)

        binding.btnCalculate.setOnClickListener {
            presenter.onCalculateClicked(
                binding.etFirstName.text.toString(),
                binding.etSecondName.text.toString()
            )
        }

    }

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToResult(loveModel: LoveModel) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("loveModel", loveModel)
        startActivity(intent)
    }

    override fun clearInputFields() {
        binding.apply {
            etFirstName.text.clear()
            etSecondName.text.clear()
            etFirstName.clearFocus()
            etSecondName.clearFocus()
        }
    }
}

