package com.example.testwebservice.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testwebservice.Model.Cat
import com.example.testwebservice.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.post_item.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.post_item.view.*

class MainAdapter(var items: List<Cat>): RecyclerView.Adapter<MainAdapter.PostHolder>() {
    override fun getItemCount() = items.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.post_item, parent, false))
    override fun onBindViewHolder(holder: PostHolder, position: Int) { holder.bind(items[position]) }

    inner class PostHolder(override val containerView: View): RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bind(item: Cat) {
           // postId.text = item.id.toString()
            tt.text = item.nomCat
         //   postBody.text = item.description
            Glide.with(containerView.context).load(item.photo).into(containerView.image)

        }
    }
}