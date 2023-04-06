package com.example.myapplication3.rest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// retrofit converter

object RestClient{
    // variable references to the BASE_URL and Retrofit
    private val BASE_URL = "https://api.stackexchange.com"
    private var mRetrofit: Retrofit? = null // ref to retrofit
    // building retrofit instance
    val client : Retrofit
          get() {
              if (mRetrofit == null){
                  mRetrofit = Retrofit.Builder()
                      .baseUrl(BASE_URL)
                      .addConverterFactory(GsonConverterFactory.create())
                      .build()
              }
              return this.mRetrofit!!
          }
}
