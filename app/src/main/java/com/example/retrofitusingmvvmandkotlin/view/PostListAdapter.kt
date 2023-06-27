package com.example.retrofitusingmvvmandkotlin.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitusingmvvmandkotlin.R
import com.example.retrofitusingmvvmandkotlin.model.Post

class PostListAdapter(private val myCourseList: ArrayList<Post.Data.MyCourse>) :
    RecyclerView.Adapter<PostViewHolder>() {

    fun updatePostList(newUpdatedPosts: List<Post.Data.MyCourse>) {
        myCourseList.clear()
        myCourseList.addAll(newUpdatedPosts)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.post_items, parent, false)
        return PostViewHolder(view)

    }

    override fun getItemCount(): Int {
        return myCourseList.size

    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.id.text = myCourseList[position].id.toString()
        holder.title.text = myCourseList[position].title
        holder.body.text = myCourseList[position].description

    }
}

class PostViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    val id: TextView = view.findViewById(R.id.textView_id)
    val title: TextView = view.findViewById(R.id.textView_title)
    val body: TextView = view.findViewById(R.id.textView_body)

}