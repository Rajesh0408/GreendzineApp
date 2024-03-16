package com.example.greendzineassignment

import android.health.connect.datatypes.units.Percentage

data class DataForProgress(
    var day : String,
    var percentage: String,
    var progress: Int
)

data class DataForProgressList(
    var ProgressList : ArrayList<DataForProgress>

) {
    fun isNotEmpty(): Boolean {
        return true
    }
}
