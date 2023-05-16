package com.example.aula4.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OperationUi(val expression: String, val result: String) : Parcelable {
    private val timestamp: Long = System.currentTimeMillis()
}