package com.alpha.bookapplication.presentation.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.alpha.bookapplication.R
import com.alpha.bookapplication.core.BaseActivity
import com.alpha.bookapplication.databinding.ActivityMainBinding
import com.alpha.bookapplication.presentation.main.adapter.CategoriesHomeAdapter


class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>(
    MainActivityViewModel::class.java,
    R.layout.activity_main
) {

    private lateinit var categoryAdapter: CategoriesHomeAdapter
    private lateinit var viewModel: MainActivityViewModel

    override fun initViewModel(viewModel: MainActivityViewModel) {
        this.viewModel=viewModel
        binding.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // bind RecyclerView
        val recyclerView = binding.viewEmployees
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.setHasFixedSize(true)
        categoryAdapter = CategoriesHomeAdapter(arrayListOf())
        recyclerView.adapter = categoryAdapter


        viewModel.getAllDoctors().observe(this, Observer{
            it?.let { categoryAdapter.updateItems(it) }
        })


    }

}
