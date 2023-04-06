package com.example.myapplication3.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.ListAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication3.R
import com.example.myapplication3.model.Question
import com.example.myapplication3.model.Questionlist
import com.example.myapplication3.rest.APIService
import com.example.myapplication3.rest.RestClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var mAPIService : APIService? = null
    private var mAdapter : ListAdapter? = null
    private var mQuestions : MutableList<Question>? = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize the interface
        mAPIService = RestClient.client.create(APIService::class.java)
        // Associating our recyclerview to a layoutmanager
        listRecyclerView!!.layoutManager = LinearLayoutManager(this)

        mAdapter = ListAdapter(this, mQuestions, 1)

        listRecyclerView!!.adapter = mAdapter
        fetchQuestions()

    }

    private fun fetchQuestions() {
        val call = mAPIService!!.fetchQuestions("android");
        call.enqueue(object : Callback<Questionlist>{
            override fun onResponse(call: Call<Questionlist>, response: Response<Questionlist>) {
                Log.d("response", "Total Questions: " + response.body()!!.items!!.size)
                val questions = response.body()
                if (questions != null){
                    mQuestions.addAll(questions.items!!)
                    mAdapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<Questionlist>, t: Throwable) {
               Toast.makeText(applicationContext,"Oops! Something went wrong, check your internet connection", Toast.LENGTH_LONG).show()


            }

        } )
    }
}