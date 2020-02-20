package com.alpha.bookapplication.presentation.doctorsList

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alpha.bookapplication.R
import com.alpha.bookapplication.core.BaseActivity
import com.alpha.bookapplication.databinding.ActivityDoctorsBinding
import com.alpha.bookapplication.presentation.doctorsList.adapter.SliderAdapter
import com.alpha.bookapplication.presentation.main.MainActivityViewModel
import kotlinx.android.synthetic.main.app_bar_layout.*

class DoctorsListActivity : BaseActivity<MainActivityViewModel, ActivityDoctorsBinding>(
    MainActivityViewModel::class.java,
    R.layout.activity_doctors
) {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var sliderAdapter: SliderAdapter

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, DoctorsListActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar = toolbar)
        createOptionsMenu(R.menu.menu_home)

        initPager()
        getAllDoctors()

    }

    private fun initPager() {
        val recyclerView = binding.rvSlider
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)
        sliderAdapter = SliderAdapter(arrayListOf())
        recyclerView.adapter = sliderAdapter
    }


    override val enableBack: Boolean = true
    override val useDrawer = false
    override fun initViewModel(viewModel: MainActivityViewModel) {
        this.viewModel = viewModel
    }

    private fun getAllDoctors() {
        viewModel.getAllDoctors().observe(this, Observer {
            it?.let { sliderAdapter.updateItems(it) }
        })
    }
}