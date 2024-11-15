package com.example.m5_l2.ui

import com.example.m5_l2.data.LoveModel

interface MainContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showError(message: String)
        fun navigateToResult(loveModel: LoveModel)
        fun clearInputFields()
    }

    interface Presenter {
        fun onCalculateClicked(firstName: String, secondName: String)
    }
}
