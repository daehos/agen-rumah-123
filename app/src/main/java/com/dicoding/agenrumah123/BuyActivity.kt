package com.dicoding.agenrumah123

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class BuyActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy)
        val btnBack: Button = findViewById(R.id.btn_back)
        btnBack.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_back -> {
                val moveIntent = Intent(this@BuyActivity, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}