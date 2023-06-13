package com.projek.bicarakuu.adapter

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.projek.bicarakuu.AbjadDetailActivity
import com.projek.bicarakuu.R
import com.projek.bicarakuu.data.DataModel

class AbjadAdapter(
    private val context: Context,
    private val dataList: List<DataModel>
) : RecyclerView.Adapter<AbjadAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.list_icon_abjad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_abjad, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList[position]
        holder.image.setImageResource(dataModel.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, AbjadDetailActivity::class.java)
            intent.putExtra("data", dataModel as Parcelable)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataList.size
}