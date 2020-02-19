package com.alpha.bookapplication.presentation.main

import androidx.lifecycle.MutableLiveData
import com.alpha.bookapplication.core.BaseViewModel
import com.alpha.bookapplication.data.model.Doctors
import com.alpha.bookapplication.data.repository.DoctorsRepo.getDoctors

class MainActivityViewModel : BaseViewModel(){

    fun getAllDoctors(): MutableLiveData<ArrayList<Doctors>> {
        return getDoctors()
    }

}