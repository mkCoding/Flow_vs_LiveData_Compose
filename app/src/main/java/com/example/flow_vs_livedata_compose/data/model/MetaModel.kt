package com.example.flow_vs_livedata_compose.data.model


import com.google.gson.annotations.SerializedName

data class MetaModel(
    @SerializedName("barcode")
    val barcode: String? = "",
    @SerializedName("createdAt")
    val createdAt: String? = "",
    @SerializedName("qrCode")
    val qrCode: String? = "",
    @SerializedName("updatedAt")
    val updatedAt: String? = ""
)