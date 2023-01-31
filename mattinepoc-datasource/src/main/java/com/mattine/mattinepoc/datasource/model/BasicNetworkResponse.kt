package com.mattine.mattinepoc.datasource.model

import com.google.gson.annotations.SerializedName
import retrofit2.Response


data class BasicNetworkResponse<T>(
    @SerializedName("code")
    val code: Int?,

    @SerializedName("success")
    val success: Boolean?,

    @SerializedName("message")
    val message: T?,
)

typealias GenericResponse<T> = Response<BasicNetworkResponse<T>>