package com.example.flow_vs_livedata_compose.data.repository

import com.example.flow_vs_livedata_compose.data.model.ProductModel
import com.example.flow_vs_livedata_compose.data.model.ProductsModel

interface ApiRepository {

    //get all products
    suspend fun getAllProducts(): ProductsModel //get all products directly from Repository

    //get product details
    suspend fun getProductDetails(productId:Int?):ProductModel
}