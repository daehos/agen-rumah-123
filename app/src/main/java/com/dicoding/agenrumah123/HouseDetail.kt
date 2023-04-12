package com.dicoding.agenrumah123

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.dicoding.agenrumah123.MainActivity.Companion.EXTRA_HOUSE

 class HouseDetail : AppCompatActivity(), View.OnClickListener{

    companion object {
        const val EXTRA_HOUSE = "extra_house"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house_detail)
        val actionbar = supportActionBar
        actionbar!!.title = "House Detail"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val ivGambarRumah: ImageView = findViewById(R.id.iv_gambar_rumah)

        val tvHarga: TextView = findViewById(R.id.tv_harga)

        val tvNamaRumah: TextView = findViewById(R.id.tv_nama_rumah)

        val tvDescription: TextView = findViewById(R.id.tv_description)

        val btnBuy: Button = findViewById(R.id.btn_buy)
        btnBuy.setOnClickListener(this)

        val btnContact:Button = findViewById(R.id.btn_contact)
        btnContact.setOnClickListener(this)

        val house = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<House>(EXTRA_HOUSE, House::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<House>(EXTRA_HOUSE)
        }
        if (house != null) {
            ivGambarRumah.setImageResource(house.photo)
            tvHarga.text = house.harga
            tvNamaRumah.text = house.name
            tvDescription.text = house.deskripsi
        }
    }
     override fun onClick(v: View?) {
         when(v?.id){
             R.id.btn_buy -> {
                 val moveIntent = Intent(this@HouseDetail, BuyActivity::class.java)
                 startActivity(moveIntent)
             }

             R.id.btn_contact -> {
                 val phoneNumber = "911"
                 val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                 startActivity(dialPhoneIntent)
             }
         }
     }
     override fun onSupportNavigateUp(): Boolean {
         onBackPressedDispatcher.onBackPressed()
         return true
     }
 }








