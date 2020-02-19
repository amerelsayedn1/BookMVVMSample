package com.alpha.bookapplication

import android.os.Bundle
import android.util.Log
import com.alpha.bookapplication.core.BaseActivity
import com.alpha.bookapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainActivityViewModel,ActivityMainBinding>(MainActivityViewModel::class.java,R.layout.activity_main) {

    override fun initViewModel(viewModel: MainActivityViewModel) {
        binding.viewModel=viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TTTT","TTTT")
    }

}
