package com.alpha.bookapplication.core

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(private var items: ArrayList<T>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    abstract fun rowBinding(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return rowBinding(parent,viewType)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    fun updateItems(data: ArrayList<T>) {
        this.items.clear()
        this.items.addAll(data)
        notifyDataSetChanged()
    }

    fun deleteAll() {
        items.clear()
        notifyDataSetChanged()
    }
}