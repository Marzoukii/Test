package com.example.testwebservice

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.testwebservice.Adapter.MainAdapter
import com.example.testwebservice.Adapter.OnItemClickListener
import kotlinx.android.synthetic.main.activity_main.*


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope

import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = MainAdapter(listOf())
        recycler.adapter = adapter

        GlobalScope.launch(Dispatchers.Main) {
            progress.visibility = View.VISIBLE
            val postsRequest = JsonPlaceholderApi.getApi().getCats()
            val postsResponse = postsRequest.await()
            progress.visibility = View.GONE
            if (postsResponse.isSuccessful) {
                adapter.items = postsResponse.body() ?: listOf()
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this@MainActivity, "Error ${postsResponse.code()}", Toast.LENGTH_SHORT).show()
            }

            recycler.addOnItemClickListener(object : OnItemClickListener {

                @RequiresApi(Build.VERSION_CODES.O)
                override fun onItemClicked(position: Int, v: View) {
                    // my logic
                    Toast.makeText(this@MainActivity, ""+ adapter.items[position].id, Toast.LENGTH_SHORT).show()
                    val i2 = Intent(this@MainActivity, DetailActivity::class.java)
                    i2.putExtra("ID",adapter.items[position].id.toString());
                    i2.putExtra("IMG",adapter.items[position].photo);
                    startActivity(i2)
                        }
                    }//*********end if view popup!=null******************//
                    //*************Add product to Cart**************************//
                    //************Listener On Add Product***********************//
            )

                }
    





        }
    private fun RecyclerView.addOnItemClickListener(onClickListener: OnItemClickListener) {
        this.addOnChildAttachStateChangeListener(object: RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewDetachedFromWindow(v: View) {
                v.setOnClickListener(null)
            }
            override fun onChildViewAttachedToWindow(v: View) {
                v.setOnClickListener {
                    val holder = getChildViewHolder(v)
                    onClickListener!!.onItemClicked(holder.adapterPosition, v)
                }
            }
        })
    }
    }
