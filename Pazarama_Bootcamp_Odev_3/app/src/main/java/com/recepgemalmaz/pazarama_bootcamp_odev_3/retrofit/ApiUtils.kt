package com.recepgemalmaz.pazarama_bootcamp_odev_3.retrofit

class ApiUtils {
    companion object {
        val BASE_URL = "https://dummy.restapiexample.com"

        fun getEmployeDao(): IHumanDao {
            var proxy: IHumanDao = RetrofitClient.getClient(BASE_URL).create(IHumanDao::class.java)
            return proxy
        }
    }
}