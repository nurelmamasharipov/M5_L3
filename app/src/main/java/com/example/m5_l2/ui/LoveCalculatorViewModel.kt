package com.example.m5_l2.ui

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.m5_l2.data.LoveModel
import com.example.m5_l2.data.RetrofitInstance
import com.example.m5_l2.utils.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveViewModel : ViewModel() {

    private val api = RetrofitInstance.api
    var isProgressVisible = MutableLiveData(false)


    fun getPercentage(
        firstName: String,
        secondName: String,
        firstActivity: Activity,
        resultActivity: Activity
    ) {
        if (firstName.isEmpty() || secondName.isEmpty()) {
            Toast.makeText(firstActivity, "Поле пустое!", Toast.LENGTH_SHORT).show()
        } else {
            isProgressVisible.value = true
            api.getPercentage(firstName, secondName, Constant.API_KEY, Constant.HOST)
                .enqueue(object : Callback<LoveModel> {
                    override fun onResponse(p0: Call<LoveModel>, response: Response<LoveModel>) {
                        isProgressVisible.value = false
                        if (response.isSuccessful && response.body() != null) {
                            val intent = Intent(firstActivity, resultActivity::class.java)
                            intent.putExtra(ResultActivity.ARG_LOVE_MODEL_KEY, response.body())
                            firstActivity.startActivity(intent)
                        }
                    }

                    override fun onFailure(p0: Call<LoveModel>, p1: Throwable) {
                        isProgressVisible.value = true
                        Toast.makeText(firstActivity, "Ошибка !", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}
