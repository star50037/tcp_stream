package com.example.vedio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Main2Activity : AppCompatActivity(){

    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnBack = findViewById(R.id.back2m)

        btnBack.setOnClickListener {
            Toast.makeText(this,"點擊",Toast.LENGTH_SHORT).show()
            jump()
        }
    }

    fun jump() {
        val intent = Intent()
        intent.setClass(this,MainActivity::class.java)
        startActivity(intent)
    }
}
