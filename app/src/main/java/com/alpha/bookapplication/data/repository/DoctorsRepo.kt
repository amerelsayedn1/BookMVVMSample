package com.alpha.bookapplication.data.repository

import androidx.lifecycle.MutableLiveData
import com.alpha.bookapplication.data.model.Doctors
import com.alpha.bookapplication.data.networking.RetroClient
import com.alpha.bookapplication.data.networking.baseRequest.Network

object DoctorsRepo {

    private val provideApi = RetroClient.provideApi()

    fun getDoctors(): MutableLiveData<ArrayList<Doctors>> {
        val data = MutableLiveData<ArrayList<Doctors>>()
        Network.request(

            request = {
                provideApi.getDoctors()
            },

            success = {
                data.value = it.data
            },

            error = {

            }

        )
        return data

    }

}