package com.example.retrofitusingmvvmandkotlin.data.api

import com.example.retrofitusingmvvmandkotlin.model.Post
import io.reactivex.Single
import retrofit2.http.POST
import retrofit2.http.Query

interface PostApi {

    @POST("getDashboardData")
    fun getPosts(@Query("sid") sid : String , @Query("course_id") courseId : String): Single<List<Post>>
}