package com.example.dmitry.kotlinpicassotest

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recyclerview_row.view.*

/**
 * Created by dmitry on 11/17/17.
 */
class RecyclerAdapter(private val images: ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.MyHolder>() {
    override fun getItemCount() = images.size

    override fun onBindViewHolder(holder: RecyclerAdapter.MyHolder, position: Int) {
        holder.bindImage(images[position])  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.MyHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_row, false)
        return MyHolder(inflatedView)
    }

    class MyHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v

        override fun onClick(v: View) {}

        fun bindImage(photo: String) {
            Kpicasso.with(view.context.applicationContext).load(photo, view.itemImage)
            view.itemDescription.text = photo
        }

    }
}