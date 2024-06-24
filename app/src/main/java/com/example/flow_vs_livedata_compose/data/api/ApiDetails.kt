package com.example.flow_vs_livedata_compose.data.api

object ApiDetails {
    //API ->  https://dummyjson.com/products
    //2nd Screen https://dummyjson.com/products/{selected index from first screen}

    //specify Base URL and endpoints
    const val BASE_URL = "https://dummyjson.com/"
    const val ENDPOINT_PRODUCTS = "products"
    const val ENDPOINT_PRODUCT_DETAILS = "products/{productId}"
}