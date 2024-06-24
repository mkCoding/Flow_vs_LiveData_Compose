package com.example.flow_vs_livedata_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.flow_vs_livedata_compose.data.model.ProductModel
import com.example.flow_vs_livedata_compose.ui.products_list.ProductListViewModel
import com.example.flow_vs_livedata_compose.ui.products_list.ProductsList
import com.example.flow_vs_livedata_compose.ui.products_list.ProductsListScreen
import com.example.flow_vs_livedata_compose.ui.theme.Flow_vs_LiveData_ComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Flow_vs_LiveData_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    val productListViewModel:ProductListViewModel = hiltViewModel()
                    ProductsListScreen(productListViewModel = productListViewModel)
                   //ProductsList(productList = myList)
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Flow_vs_LiveData_ComposeTheme {
        val myList:MutableList<ProductModel?>? = mutableListOf()
        myList?.add(
            ProductModel(
                id = 1,
                brand = "Nice Brand",
                title = "Phone",
                thumbnail = "https://www.att.com/scmsassets/global/devices/phones/apple/apple-iphone-15-pro-max/carousel/natural-titanium-1.png",
                price = 12.68)
        )
        myList?.add(
            ProductModel(
                id = 2,
                brand = "Cool Brand",
                title = "Conference Chair",
                thumbnail = "https://cdn.dummyjson.com/products/images/furniture/Knoll%20Saarinen%20Executive%20Conference%20Chair/thumbnail.png",
                price = 50.68)
        )
        myList?.add(
            ProductModel(
                id = 3,
                brand = "Sky Brand",
                title = "Red Nail Polish",
                thumbnail = "https://cdn.dummyjson.co…l%20Polish/thumbnail.png",
                price = 500.30)
        )



        ProductsList(productList = myList)
    }
}