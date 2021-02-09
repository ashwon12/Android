package com.example.viewpager2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {

    private var titleList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postToList()

        view_pager2.adapter = ViewPagerAdapter(titleList,imagesList)
        view_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(view_pager2)
    }

    private fun addToList(title:String, image : Int){
        titleList.add(title)
        imagesList.add(image)
    }

    private fun postToList(){
        for(i in 1..5){
            addToList("Title ${i}",R.mipmap.ic_launcher_round)
        }
    }
}