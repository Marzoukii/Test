package com.example.testwebservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.post_item.view.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val extras = intent.extras
        val id_resto= extras!!.getString("ID");
   //  id=id_resto.toString()
        val imageR= extras!!.getString("IMG");
       // tab=table.toString()


        TX.text=id_resto
        Glide.with(this).load(imageR).into(pp)
    }
}