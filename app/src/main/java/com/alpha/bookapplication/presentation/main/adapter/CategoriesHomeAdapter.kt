package com.alpha.bookapplication.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alpha.bookapplication.core.BaseAdapter
import com.alpha.bookapplication.core.BaseViewHolder
import com.alpha.bookapplication.data.model.Doctors
import com.alpha.bookapplication.databinding.ItemCategoryBinding

class CategoriesHomeAdapter(private val data: ArrayList<Doctors>) : BaseAdapter<Doctors>(data) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as CategoryViewHolder
        holder.bind(data[position])

    }

    override fun rowBinding(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class CategoryViewHolder(private val item: ItemCategoryBinding) :
        BaseViewHolder<Doctors>(item) {

        override fun bind(data: Doctors) {
            item.model = data
            item.position = adapterPosition
            item.itemClick = onItemClicked
        }
    }


}