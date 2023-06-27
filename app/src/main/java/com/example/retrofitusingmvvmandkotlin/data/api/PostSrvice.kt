package com.example.retrofitusingmvvmandkotlin.data.api

import com.example.retrofitusingmvvmandkotlin.model.Post
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PostSrvice {
    private val BASE_URl ="https://irctc.chalksnboard.com/api/v2/";

    private val authToken = "44b48f2305bf26234"
    private val apiKey = "Authorization"

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(authToken, apiKey))
        .build()

    private  val api = Retrofit.Builder()
        .baseUrl(BASE_URl)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(PostApi::class.java)

    fun getposts(sid : String , courseId : String) : Single<List<Post>>{
        return api.getPosts(sid,courseId)
    }
}