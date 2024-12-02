package com.example.m5_l2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m5_l2.data.local.LoveDao
import com.example.m5_l2.data.local.LoveEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val loveResultDao: LoveDao
): ViewModel() {

    val historyList: LiveData<List<LoveEntity>> = loveResultDao.getAllResultsSortedByName()


    fun deleteHistoryItem(item: LoveEntity) {
        viewModelScope.launch {
            loveResultDao.delete(item)
        }
    }

    fun insertResult(loveResult: LoveEntity) {
        viewModelScope.launch {
            loveResultDao.insert(loveResult)
        }
    }
}
