package com.example.ohashi_pc.geocodingapitest.apis

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory


class GeocodingApiClient {
    private val retrofit = Retrofit.Builder()
            .client(OkHttpClient())
            .baseUrl("https://www.geocoding.jp/api/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()

}