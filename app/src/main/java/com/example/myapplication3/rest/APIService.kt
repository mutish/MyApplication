package com.example.myapplication3.rest

import com.example.myapplication3.model.Questionlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    // GET -> indicate HTTP request mode
    // Query -> add query parameters to parameters
    // call -> object type parameter indicating what data it is expecting from the result
    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    fun fetchQuestions(@Query("tagged") tags: String) : Call<Questionlist>
}