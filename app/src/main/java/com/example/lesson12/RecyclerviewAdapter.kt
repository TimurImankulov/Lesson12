package com.example.lesson12

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewAdapter(private val listener: RecyclerviewListener) : RecyclerView.Adapter<RecyclerviewViewHolder>() {

    private var data = arrayListOf<DataClass>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return RecyclerviewViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RecyclerviewViewHolder, position: Int) {
        holder.bind(data[position], listener, position)
    }

    fun update(data: ArrayList<DataClass>) {
        this.data = data
        notifyDataSetChanged()
    }

    fun delete(pos: Int) {
        if (pos > -1 && data.size > pos) {
            data.removeAt(pos)
            notifyItemRemoved(pos)
            notifyItemRangeChanged(pos, data.size)
        }
    }

    fun add(item: DataClass) {
        data.add(1, item)
        notifyItemInserted(1)
    }
}