package com.recepgemalmaz.pazarama_bootcamp_odev_3.retrofit

import com.recepgemalmaz.pazarama_bootcamp_odev_3.entity.CRUDCevap
import retrofit2.Call
import retrofit2.http.GET

interface IHumanDao {

    @GET("/api/v1/employees")
    fun getEmployees() :Call<CRUDCevap>
}