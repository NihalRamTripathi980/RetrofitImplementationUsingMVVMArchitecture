package com.example.retrofitusingmvvmandkotlin.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitusingmvvmandkotlin.data.api.PostSrvice
import com.example.retrofitusingmvvmandkotlin.model.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class PostListViewModel : ViewModel() {
    val posts =MutableLiveData<List<Post>>()
    private val postService : PostSrvice=PostSrvice()
    private val disposable : CompositeDisposable = CompositeDisposable()
    var myCourseList = ArrayList<Post.Data.MyCourse>()

    fun refresh(){
        fetchDataFromRemoteApi()
    }

    fun fetchDataFromRemoteApi(){
        disposable.add(
            postService.getposts(sid=String() , courseId = String())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object :DisposableSingleObserver<List<Post>>(){
                        override fun onSuccess(response: List<Post>) {
                            val status = response[0].status
                            Log.e(TAG, "onSuccess: $status")
                            if (status == "success") {
                                val data = response[0].data
                                myCourseList = data.my_courses as ArrayList<Post.Data.MyCourse>
//                                val popularCourses = data.popular_courses
                                // Assuming the response contains a single post, you can access it like this:
                            } else {
                                // Handle error or unsuccessful response
                                // You can display an error message or perform any other necessary actions
                            }
                            posts.value = response
                        }
                        override fun onError(e: Throwable) {
                           e.printStackTrace()
                        }

                    })

        )

    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}