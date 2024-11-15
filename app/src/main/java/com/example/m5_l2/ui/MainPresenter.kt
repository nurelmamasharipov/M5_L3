package com.example.m5_l2.ui

import com.example.m5_l2.data.LoveModel
import com.example.m5_l2.data.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {
    private val api = RetrofitInstance.api

    override fun onCalculateClicked(firstName: String, secondName: String) {
        if (firstName.isEmpty() || secondName.isEmpty()) {
            view.showError("Не набрано ни одного символа")
            return
        }

        view.showLoading()
        api.getPercentage(
            firstName = firstName,
            secondName = secondName,
            key = "c732f0c4e3msh91a761a72200d2dp184bf2jsn54b4a6407fe2",
            host = "love-calculator.p.rapidapi.com"
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                view.hideLoading()
                if (response.isSuccessful && response.body() != null) {
                    view.clearInputFields()
                    view.navigateToResult(response.body()!!)
                } else {
                    view.showError("Ошибка в получении данных")
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                view.hideLoading()
                view.showError(t.message ?: "Неизвестная ошибка")
            }
        })
    }
}
