package com.ahmettekin.mylandscapes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tumManzaralar = ArrayList<Manzara>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynaginiDoldur()

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = ManzaraAdapter(tumManzaralar)
    }

    fun veriKaynaginiDoldur(): ArrayList<Manzara> {

        val tumResimler = arrayOf(
            R.drawable.thumb_1_0, R.drawable.thumb_1_1, R.drawable.thumb_1_2, R.drawable.thumb_1_3,
            R.drawable.thumb_1_4, R.drawable.thumb_1_5, R.drawable.thumb_1_6, R.drawable.thumb_1_7,
            R.drawable.thumb_1_8, R.drawable.thumb_1_9,

            R.drawable.thumb_2_0, R.drawable.thumb_2_1, R.drawable.thumb_2_2, R.drawable.thumb_2_3,
            R.drawable.thumb_2_4, R.drawable.thumb_2_5, R.drawable.thumb_2_6, R.drawable.thumb_2_7,
            R.drawable.thumb_2_8, R.drawable.thumb_2_9,

            R.drawable.thumb_3_0, R.drawable.thumb_3_1, R.drawable.thumb_3_2, R.drawable.thumb_3_3,
            R.drawable.thumb_3_4, R.drawable.thumb_3_5, R.drawable.thumb_3_6, R.drawable.thumb_3_7,
            R.drawable.thumb_3_8, R.drawable.thumb_3_9,

            R.drawable.thumb_4_0, R.drawable.thumb_4_1, R.drawable.thumb_4_2, R.drawable.thumb_4_3,
            R.drawable.thumb_4_4, R.drawable.thumb_4_5, R.drawable.thumb_4_6, R.drawable.thumb_4_7,
            R.drawable.thumb_4_8, R.drawable.thumb_4_9,

            R.drawable.thumb_5_0, R.drawable.thumb_5_1, R.drawable.thumb_5_2, R.drawable.thumb_5_3,
            R.drawable.thumb_5_4, R.drawable.thumb_5_5, R.drawable.thumb_5_6, R.drawable.thumb_5_7,
            R.drawable.thumb_5_8, R.drawable.thumb_5_9,

            R.drawable.thumb_6_0, R.drawable.thumb_6_1, R.drawable.thumb_6_2, R.drawable.thumb_6_3,
            R.drawable.thumb_6_4, R.drawable.thumb_6_5, R.drawable.thumb_6_6, R.drawable.thumb_6_7,
            R.drawable.thumb_6_8, R.drawable.thumb_6_9,

            R.drawable.thumb_7_0, R.drawable.thumb_7_1, R.drawable.thumb_7_2, R.drawable.thumb_7_3,
            R.drawable.thumb_7_4
        )

        for (i in tumResimler.indices) {

            val eklenecekManzara = Manzara("Manzara: $i", "Açıklama: $i", tumResimler[i])
            tumManzaralar.add(eklenecekManzara)
        }

        return tumManzaralar
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.ana_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menuLinearViewHorizontal -> {
                recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            }
            R.id.menuLinearViewVertical -> {
                recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            }
            R.id.menuGrid -> {
                recyclerView.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.menuStaggeredHorizontal -> {
                recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
            }
            R.id.menuStaggeredVertical -> {
                recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}