package com.example.retrofitusingmvvmandkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitusingmvvmandkotlin.R
import com.example.retrofitusingmvvmandkotlin.databinding.ActivityMainBinding
import com.example.retrofitusingmvvmandkotlin.viewmodel.PostListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PostListViewModel
    private var postListAdapter= PostListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel=ViewModelProvider(this).get(PostListViewModel::class.java)
        viewModel.refresh()

        binding.postsList.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=postListAdapter
        }
        observeViewModel()

    }
    private fun observeViewModel(){
        viewModel.posts.observe(this, Observer { postList ->
            postList?.let {
                postListAdapter.updatePostList(viewModel.myCourseList)
            }
        })
    }
}