package com.example.dmitry.kotlinpicassotest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    // 20-30 картинок из сети
    private val imagesList: ArrayList<String> = arrayListOf(
            "hthhhtps://wkkww.nannmsa.gov/sites/default/files/styles/imagjhghfgghjkle_card_4x3_ratio/public/thumbnails/image/afrc2017-0068-hgfhgfh123.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/thumbnails/image/img_9609.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/thumbnails/image/img_9571.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/dsc_2421_0.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/dsc_2308.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/14-642_mcl_cir.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/ed13-0225-274.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/jsc2013e074468.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/610701main_ED11-0321-10_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/610725main_ED11-0321-18_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/510204main_ED10-0383-067_full_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/510220main_ED10-0383-091_full_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/510171main_ED10-0383-079_full_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/417046main_ED10-0007-19_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/464840main_JSC2010e078970_full_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/417034main_ED10-0007-04_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/403772main_EC98-44435-3_full_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/610701main_ED11-0321-10_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/610725main_ED11-0321-18_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/510204main_ED10-0383-067_full_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/510220main_ED10-0383-091_full_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/610701main_ED11-0321-10_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/610725main_ED11-0321-18_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/510204main_ED10-0383-067_full_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/510220main_ED10-0383-091_full_full.jpg",
            "https://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/images/510171main_ED10-0383-079_full_full.jpg"
    )

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        adapter = RecyclerAdapter(imagesList)
        recyclerView.adapter = adapter
    }
}
