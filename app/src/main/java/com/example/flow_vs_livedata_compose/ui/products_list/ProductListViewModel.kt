package com.example.flow_vs_livedata_compose.ui.products_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flow_vs_livedata_compose.data.model.ProductModel
import com.example.flow_vs_livedata_compose.data.model.ProductsModel
import com.example.flow_vs_livedata_compose.data.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(val repository: ApiRepository):ViewModel() {

    //LiveData
    //Product List
    private val _productListLive  = MutableLiveData<List<ProductModel?>?>()
    val productListLive:LiveData<List<ProductModel?>?> = _productListLive

    //Flow
    private val _productListFlow = MutableStateFlow<List<ProductModel?>?>(emptyList())
    val productListFlow: StateFlow<List<ProductModel?>?> = _productListFlow


    init {
//        getAllProductsLive()
        getAllProductsFlow()
    }

    private fun getAllProductsLive() {
        viewModelScope.launch {

            val allProducts = repository.getAllProducts().products

            if(allProducts!= null){
                _productListLive.postValue(allProducts)
                Log.d("ProductListViewModelLive", allProducts.toString())
            }

        }
    }

    private fun getAllProductsFlow() {
        viewModelScope.launch {

            val allProducts = repository.getAllProducts().products

            if(allProducts!= null){
                //transform every other element in the list
                val transformedProducts = allProducts.withIndex()
                    .filter { it.index% 2 == 0 }
                    .map { it.value }

                _productListFlow.value = transformedProducts
//                _productListFlow.value = allProducts


                Log.d("ProductListViewModelFlow",transformedProducts.toString())
            }

        }
    }

}