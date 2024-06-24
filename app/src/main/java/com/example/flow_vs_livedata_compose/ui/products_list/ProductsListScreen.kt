package com.example.flow_vs_livedata_compose.ui.products_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.flow_vs_livedata_compose.data.model.ProductModel

@Composable
fun ProductsListScreen( productListViewModel: ProductListViewModel) {

    val productsListLive by productListViewModel.productListLive.observeAsState() //variable to accessing list from view model

    val productListFlow by productListViewModel.productListFlow.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Products",
            style =  TextStyle(fontSize = 25.sp),
            modifier = Modifier.padding(bottom = 20.dp)
        )

//        ProductsList(productsListLive) //list will be passed in form the viewmodel (Live)
        ProductsList(productListFlow) //Flow

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsList(productList:List<ProductModel?>?){
    LazyColumn (
        modifier = Modifier
            .height(900.dp)
    ){
        items(productList?: emptyList()) { itemiuk ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .padding(8.dp)

            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                    
                ){
                    Text(
                        text = "Title: ${itemiuk?.title}",
                        modifier = Modifier,
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                }

                Row (

                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(16.dp)
                        .padding(end = 16.dp)


                ){
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .padding(end = 16.dp)

                    ) {
                        Text(text = "Brand: ${itemiuk?.brand}", modifier = Modifier.padding(bottom = 5.dp))
                        Text(text = "Price ${itemiuk?.price}")
                        Spacer(modifier = Modifier.weight(1f))

                        if (itemiuk != null) {
                            Image(
                                painter = rememberImagePainter(data = itemiuk?.thumbnail),
                                contentDescription = "Image",
                                modifier = Modifier.size(100.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }

            }
       }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewProductsScreen() {

//    val myList:MutableList<ProductModel?>? = mutableListOf()
//    myList?.add(
//        ProductModel(
//            id = 1,
//            brand = "Nice Brand",
//            title = "Phone",
//            thumbnail = "https://www.att.com/scmsassets/global/devices/phones/apple/apple-iphone-15-pro-max/carousel/natural-titanium-1.png",
//            price = 12.68)
//    )
//    myList?.add(
//        ProductModel(
//            id = 2,
//            brand = "Cool Brand",
//            title = "Conference Chair",
//            thumbnail = "https://cdn.dummyjson.com/products/images/furniture/Knoll%20Saarinen%20Executive%20Conference%20Chair/thumbnail.png",
//            price = 50.68)
//    )
//    myList?.add(
//        ProductModel(
//            id = 3,
//            brand = "Sky Brand",
//            title = "Red Nail Polish",
//            thumbnail = "https://cdn.dummyjson.co…l%20Polish/thumbnail.png",
//            price = 500.30)
//    )
//
//
//    ProductsScreen(myList)
}