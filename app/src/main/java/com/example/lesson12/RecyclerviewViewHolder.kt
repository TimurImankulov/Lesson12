package com.example.lesson12

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rv.view.*

class RecyclerviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(
        item: DataClass,
        listener: RecyclerviewListener,
        position: Int
    ) {
        itemView.tvText.text = item.title
        itemView.tvText1.text = item.title1

        itemView.btnDelete.setOnClickListener {
            listener.itemClicks(position)
        }
    }
}