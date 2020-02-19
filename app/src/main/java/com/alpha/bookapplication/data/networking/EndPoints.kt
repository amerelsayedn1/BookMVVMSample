package com.alpha.bookapplication.data.networking

import com.alpha.bookapplication.data.model.BaseModel
import com.alpha.bookapplication.data.model.Doctors
import retrofit2.Response
import retrofit2.http.GET

interface EndPoints {

    @GET("employees")
    suspend fun getDoctors(): Response<BaseModel<ArrayList<Doctors>>>

}