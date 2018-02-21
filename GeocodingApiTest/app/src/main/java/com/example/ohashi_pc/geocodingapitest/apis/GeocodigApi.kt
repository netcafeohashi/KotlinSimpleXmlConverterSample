package com.example.ohashi_pc.geocodingapitest.apis

import com.example.ohashi_pc.geocodingapitest.apis.entity.GeoXml
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodigApi {
    @GET("/api")
    fun getGeocoding(@Query("q") param: String): Call<GeoXml>
}
