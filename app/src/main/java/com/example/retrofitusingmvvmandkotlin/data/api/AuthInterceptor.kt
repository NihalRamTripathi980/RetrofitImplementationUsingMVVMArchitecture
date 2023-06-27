package com.example.retrofitusingmvvmandkotlin.data.api

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val authToken: String, private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            .header("Authorization", authToken)
            .header("API-Key", apiKey)
            .build()
        return chain.proceed(modifiedRequest)
    }
}