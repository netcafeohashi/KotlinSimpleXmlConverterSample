package com.example.ohashi_pc.geocodingapitest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.ohashi_pc.geocodingapitest.apis.GeocodigApi
import com.example.ohashi_pc.geocodingapitest.apis.entity.GeoXml
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById(R.id.text) as TextView

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        val httpclinet = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
                .client(httpclinet)
                .baseUrl("https://www.geocoding.jp")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
        val call = retrofit.create(GeocodigApi::class.java).getGeocoding("大阪府大阪市北区大深町４−１")
        call.enqueue(object : Callback<GeoXml> {
            override fun onResponse(call: Call<GeoXml>, response: Response<GeoXml>) {
                val responseGeoXml = response.body()?.coodinate
                textView.text = responseGeoXml?.latitudem + "," + responseGeoXml?.longitudem
            }


            override fun onFailure(call: Call<GeoXml>, t: Throwable) {
                println(t.localizedMessage)
            }
        })
    }
}