package com.example.flow_vs_livedata_compose.data.api

import com.example.flow_vs_livedata_compose.data.model.ProductModel
import com.example.flow_vs_livedata_compose.data.model.ProductsModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndpoints {

    @GET(ApiDetails.ENDPOINT_PRODUCTS)
    suspend fun getAllProducts():ProductsModel //all products

    @GET(ApiDetails.ENDPOINT_PRODUCT_DETAILS)
    suspend fun getProductDetails(@Path("productId") productId:Int?):ProductModel //specific product details
}