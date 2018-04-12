package com.sample.kotlintest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var pages: List<String> = ArrayList()

    init {
        pages = arrayListOf("test1", "test1", "test1", "test1", "test1", "test1", "test1", "test1", "test1")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    fun initView() {
        lv_main.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pages)
        lv_main.visibility = View.VISIBLE
        lv_main.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "点击了第$position 的item", Toast.LENGTH_SHORT).show()
        }
    }


}
