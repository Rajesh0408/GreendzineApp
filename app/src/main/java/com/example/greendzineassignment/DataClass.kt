package com.example.greendzineassignment


data class DataClass(
    var emp_id: Int,
    var name: String,
    var dob: String,
    var role: String
)

data class DataClassList (
    var employees: ArrayList<DataClass>
) {
    fun isNotEmpty(): Boolean {
            return true
    }
}