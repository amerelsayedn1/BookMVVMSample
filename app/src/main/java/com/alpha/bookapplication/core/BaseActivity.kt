package com.alpha.bookapplication.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider


abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding>(private val mViewModelClass: Class<VM>, @LayoutRes private val layoutResId: Int) :
    AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(mViewModelClass)
    }

    val binding by lazy {
        DataBindingUtil.setContentView(this, layoutResId) as DB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initViewModel(viewModel)
        super.onCreate(savedInstanceState)
        binding
    }


    /**
     *
     *  You need override this method.
     *  And you need to set viewModel to binding: binding.viewModel = viewModel
     *
     */
    abstract fun initViewModel(viewModel: VM)

}