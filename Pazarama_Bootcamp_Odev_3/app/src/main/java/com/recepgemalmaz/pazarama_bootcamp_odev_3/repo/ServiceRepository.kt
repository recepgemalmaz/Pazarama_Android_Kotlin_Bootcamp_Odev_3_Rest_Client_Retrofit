package com.recepgemalmaz.pazarama_bootcamp_odev_3.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData

import com.recepgemalmaz.pazarama_bootcamp_odev_3.entity.CRUDCevap
import com.recepgemalmaz.pazarama_bootcamp_odev_3.entity.Employee
import com.recepgemalmaz.pazarama_bootcamp_odev_3.retrofit.ApiUtils
import com.recepgemalmaz.pazarama_bootcamp_odev_3.retrofit.IHumanDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceRepository {
    var EmployeListesi = MutableLiveData<List<Employee>>()
    var EmployeDaoInterface: IHumanDao
    init {
        EmployeDaoInterface = ApiUtils.getEmployeDao()
    }

    fun kisileriGetir():MutableLiveData<List<Employee>>{
        return EmployeListesi
    }

    fun EmployeListesiGetir() {
        EmployeDaoInterface.getEmployees() .enqueue(object : Callback<CRUDCevap> {

            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {

                if (response.body() != null) {

                    val liste = response.body().data
                    EmployeListesi.value = liste
                } else {
                    Log.e("HATA", "Liste boş geldi")
                }

            }
            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
            }
        })
    }




}