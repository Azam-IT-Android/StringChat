package com.example.stringchat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.android_version_item_layout.view.*

class AndroidVersionsAdapter: RecyclerView.Adapter<AndroidVersionsAdapter.VersionViewHolder>() {

    class VersionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.android_version_item_layout, parent, false)
        return VersionViewHolder(view)
    }

    override fun onBindViewHolder(holder: VersionViewHolder, position: Int) {
        val version = versions[position]
        holder.itemView.codeNameText.text = version.codeName
        holder.itemView.versionNameText.text = version.versionName
    }

    override fun getItemCount(): Int {
        return versions.size
    }
}