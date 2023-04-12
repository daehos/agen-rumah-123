package com.dicoding.agenrumah123

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHouse: RecyclerView
    private val list = ArrayList<House>()

    companion object {
        const val EXTRA_HOUSE = "extra_house"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHouse = findViewById(R.id.rv_houses)
        rvHouse.setHasFixedSize(true)

        list.addAll(getListHouses())
        showRecyclerList()
    }

    private fun getListHouses(): ArrayList<House> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataHarga = resources.getStringArray(R.array.data_harga)
        val dataDeskripsi = resources.getStringArray(R.array.data_desription_detail)

        val listHouse = ArrayList<House>()
        for (i in dataName.indices) {
            val House = House( dataPhoto.getResourceId(i, -1), dataName[i], dataDescription[i],dataHarga[i], dataDeskripsi[i])
            listHouse.add(House)
        }
        return listHouse
    }

    private fun showRecyclerList() {
        rvHouse.layoutManager = LinearLayoutManager(this)
        val listHouseAdapter = ListHouseAdapter(list)
        rvHouse.adapter = listHouseAdapter

        listHouseAdapter.setOnItemClickCallback(object : ListHouseAdapter.OnItemClickCallback {
            override fun onItemClicked(data: House) {
                sendData(data)
            }

            private fun sendData(data: House) {
                val intent = Intent(this@MainActivity, HouseDetail::class.java)
                intent.putExtra(EXTRA_HOUSE, data)
                startActivity(intent)
            }

        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_me, menu)
        val intent = Intent(this, ContactActivity::class.java)
        menu?.findItem(R.id.about_me_activity)?.setOnMenuItemClickListener {
            startActivity(intent)
            true
        }
        return super.onCreateOptionsMenu(menu)
    }
}