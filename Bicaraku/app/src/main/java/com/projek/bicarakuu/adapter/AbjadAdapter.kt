package com.projek.bicarakuu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.projek.bicarakuu.R
import com.projek.bicarakuu.data.DataModel

class AbjadAdapter(private val context: Context, private var dataList: List<DataModel>) : RecyclerView.Adapter<AbjadAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.list_icon_abjad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_abjad, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.image.setImageResource(data.image)
    }

    override fun getItemCount() = dataList.size
}