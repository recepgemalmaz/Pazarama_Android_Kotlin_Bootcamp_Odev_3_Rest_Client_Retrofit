package com.recepgemalmaz.pazarama_bootcamp_odev_3.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.recepgemalmaz.pazarama_bootcamp_odev_3.entity.Employee
import com.recepgemalmaz.pazarama_bootcamp_odev_3.repo.ServiceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class HumanResourcesVM ():ViewModel(){

    var EmployeeList = MutableLiveData<List<Employee>>()
    var krepo = ServiceRepository()

    init {
        EmployeYukle()
        EmployeeList = krepo.kisileriGetir()
    }

    fun EmployeYukle(){
        krepo.EmployeListesiGetir()
    }
}