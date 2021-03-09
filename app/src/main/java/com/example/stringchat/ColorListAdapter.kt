package com.example.stringchat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.color_list_item_layout.view.*

class ColorListAdapter: RecyclerView.Adapter<ColorListAdapter.ColorViewHolder>() {

    class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.color_list_item_layout, parent, false)
        return ColorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.itemView.colorPreview.setBackgroundColor(colors[position].value)
        holder.itemView.colorName.text = colors[position].name
    }

    override fun getItemCount(): Int {
        return colors.size
    }
}