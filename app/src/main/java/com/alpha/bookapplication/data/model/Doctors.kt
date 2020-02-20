package com.alpha.bookapplication.data.model


import com.google.gson.annotations.SerializedName

data class Doctors(
    @SerializedName("id")
    val id: String,
    @SerializedName("employee_name")
    val employeeName: String,
    @SerializedName("employee_salary")
    val employeeSalary: String,
    @SerializedName("employee_age")
    val employeeAge: String,
    val profile: String="https://amayei.nyc3.digitaloceanspaces.com/2019/09/Heart-Disease.jpeg"
)