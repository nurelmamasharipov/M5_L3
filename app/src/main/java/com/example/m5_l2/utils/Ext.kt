package com.example.m5_l2.utils

import android.widget.EditText

fun EditText.focusAndClear(){
    clearFocus()
    text.clear()
}

fun EditText.getTextName() = text.toString()