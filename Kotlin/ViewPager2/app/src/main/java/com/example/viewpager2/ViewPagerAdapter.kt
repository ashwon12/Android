package com.example.viewpager2

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(private var title: List<String>, private var images: List<Int>) :
    RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTitle: TextView = itemView.findViewById(R.id.textView)
        val itemImages: ImageView = itemView.findViewById(R.id.imageView)

        init {
            itemImages.setOnClickListener { v: View ->
                val position = adapterPosition
                Toast.makeText(itemView.context, "너는 ${position + 1}번 클릭 했다.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.PagerViewHolder {
        return PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun getItemCount(): Int {
        return title.size
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.PagerViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemImages.setImageResource(images[position])
    }
}