package com.alpha.bookapplication.presentation.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.alpha.bookapplication.R
import com.alpha.bookapplication.core.BaseActivity
import com.alpha.bookapplication.core.BaseAdapter
import com.alpha.bookapplication.data.model.Doctors
import com.alpha.bookapplication.databinding.ActivityMainBinding
import com.alpha.bookapplication.presentation.doctorsList.DoctorsListActivity
import com.alpha.bookapplication.presentation.main.adapter.CategoriesHomeAdapter
import kotlinx.android.synthetic.main.app_bar_layout.*


class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>(
    MainActivityViewModel::class.java,
    R.layout.activity_main
), BaseAdapter.OnItemClickedListener<Doctors> {

    private lateinit var categoryAdapter: CategoriesHomeAdapter
    private lateinit var viewModel: MainActivityViewModel

    override fun initViewModel(viewModel: MainActivityViewModel) {
        this.viewModel = viewModel
        binding.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar = toolbar)
        createOptionsMenu(R.menu.menu_home)

        // bind RecyclerView
        val recyclerView = binding.viewEmployees
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.setHasFixedSize(true)
        categoryAdapter = CategoriesHomeAdapter(arrayListOf())
        recyclerView.adapter = categoryAdapter
        categoryAdapter.setOnItemClickListener(this)

        getAllDoctors()

    }


    private fun getAllDoctors() {
        viewModel.getAllDoctors().observe(this, Observer {
            it?.let { categoryAdapter.updateItems(it) }
            binding.progress.visibility=View.GONE
        })
    }

    override fun onItemClickListener(view: View, model: Doctors) {
        startActivity(DoctorsListActivity.getStartIntent(this@MainActivity))
    }

    override val enableBack: Boolean = false
    override val useDrawer = true

}
