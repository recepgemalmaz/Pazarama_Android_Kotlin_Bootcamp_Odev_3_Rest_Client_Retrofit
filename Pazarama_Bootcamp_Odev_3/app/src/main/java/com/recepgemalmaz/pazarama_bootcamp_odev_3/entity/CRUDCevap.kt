package com.recepgemalmaz.pazarama_bootcamp_odev_3.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CRUDCevap
    (
    @SerializedName("status"  ) @Expose var status  : String,
    @SerializedName("data"    ) @Expose var data    : List<Employee>,
    @SerializedName("message" ) @Expose var message : String
            )
/*
data class KisilerCevap(@SerializedName("kisiler")
                        @Expose
                        var kisiler:List<Kisiler>,





                        @SerializedName("success")
                        @Expose
                        var success:Int) {


                        data class ExampleJson2KtKotlin (

  @SerializedName("status"  ) var status  : String?         = null,
  @SerializedName("data"    ) var data    : ArrayList<Data> = arrayListOf(),
  @SerializedName("message" ) var message : String?         = null

)
 */