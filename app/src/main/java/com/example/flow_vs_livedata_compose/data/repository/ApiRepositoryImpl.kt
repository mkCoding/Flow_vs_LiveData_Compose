package com.example.flow_vs_livedata_compose.data.repository

import com.example.flow_vs_livedata_compose.data.api.ApiEndpoints
import com.example.flow_vs_livedata_compose.data.model.ProductModel
import com.example.flow_vs_livedata_compose.data.model.ProductsModel
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(private val apiEndpoints: ApiEndpoints):ApiRepository{
    override suspend fun getAllProducts(): ProductsModel  = apiEndpoints.getAllProducts()

    override suspend fun getProductDetails(productId: Int?): ProductModel = apiEndpoints.getProductDetails(productId)

}