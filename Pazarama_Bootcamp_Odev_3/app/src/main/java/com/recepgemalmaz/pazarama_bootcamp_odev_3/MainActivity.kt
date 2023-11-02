package com.recepgemalmaz.pazarama_bootcamp_odev_3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.recepgemalmaz.pazarama_bootcamp_odev_3.entity.Employee
import com.recepgemalmaz.pazarama_bootcamp_odev_3.repo.ServiceRepository
import com.recepgemalmaz.pazarama_bootcamp_odev_3.retrofit.ApiUtils
import com.recepgemalmaz.pazarama_bootcamp_odev_3.retrofit.IHumanDao
import com.recepgemalmaz.pazarama_bootcamp_odev_3.retrofit.RetrofitClient
import com.recepgemalmaz.pazarama_bootcamp_odev_3.ui.theme.Pazarama_Bootcamp_Odev_3Theme
import com.recepgemalmaz.pazarama_bootcamp_odev_3.viewmodel.HumanResourcesVM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Pazarama_Bootcamp_Odev_3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EmployeesListDisplay()
                }
            }
        }
    }
}

@Composable
fun EmployeeDisplay(e: Employee) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Blue)
    ) {
        Text(text = e.employee_name, color = Color.White)
        Spacer(
            modifier = Modifier
                .width(5.dp)
                .height(5.dp)
        )
        Text(text = "Age: " + e.employee_age.toString(), color = Color.White)
        Spacer(
            modifier = Modifier
                .width(5.dp)
                .height(5.dp)
        )
        Text(text = "Salary: " + e.employee_salary.toString(), color = Color.White)
    }
    Spacer(modifier = Modifier.height(5.dp))

}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeesListDisplay() {

    val viewModel: HumanResourcesVM = viewModel()
    val EmployeListesi = viewModel.EmployeeList.observeAsState(listOf())
    LaunchedEffect(key1 = true){
        viewModel.EmployeYukle()
    }
    LazyColumn(contentPadding = PaddingValues(5.dp), userScrollEnabled = true)
    {
        this.items(
            count = EmployeListesi.value!!.count(),
            itemContent = {
                val emply= EmployeListesi.value!![it]
                EmployeeDisplay(e = emply)
            }
        )
    }
}
