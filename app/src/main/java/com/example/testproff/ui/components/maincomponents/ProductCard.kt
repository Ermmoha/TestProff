package com.example.testproff.ui.components.maincomponents

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testproff.R
import com.example.testproff.model.CardItem
import com.example.testproff.model.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCard(
    painter: Int,
    name: String,
    title: String,
    price: String,
    isLike: Boolean,
    isAdd: Boolean

){
    var isAdded by remember { mutableStateOf(isAdd) }
    var isLiked by remember { mutableStateOf(isLike) }
    Card(
        onClick = { },
        modifier = Modifier
            .size(160.dp, 178.dp),
        shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                containerColor = Color.White
                )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier.fillMaxWidth()
            ){
                Image(
                    painter = painterResource(painter),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 18.dp,)
                        .size(120.dp, 70.dp)
                    )
                IconButton(
                    modifier = Modifier
                        .padding(end = 117.dp, top = 8.dp)
                        .size(28.dp, 28.dp),
                    onClick = { isLiked = !isLiked }
                ) {
                    Icon(
                        modifier = Modifier.size(28.dp, 28.dp),
                        painter = if (!isLiked)
                            painterResource(R.drawable.heart)
                        else painterResource(R.drawable.heartcolor),
                        contentDescription = null,
                        tint = Color.Unspecified
                        )
                }
            }
            Column {
                Text(
                    modifier = Modifier.padding(top = 12.dp, start = 8.dp),
                    text = "BEST SELLER",
                    fontSize = 12.sp,
                    color = Color(72, 178, 231,)
                    )
                Text(
                    modifier = Modifier.padding(top = 4.dp, start = 8.dp),
                    text = "Nike Air Max",
                    fontSize = 16.sp,
                    color = Color(106, 106, 106,)
                )
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 8.dp),
                    fontSize = 11.sp,
                    text = "₽752.00",
                    fontWeight = FontWeight.Normal
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .background(Color(72, 178, 231,), RoundedCornerShape(topStart = 19.dp))
                        .align(Alignment.BottomEnd)
                        .size(34.dp, 36.dp)
                ) {
                    IconButton(
                        modifier = Modifier
                            .size(34.dp,34.dp),
                                onClick = { isAdded = !isAdded }
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(21.dp,15.dp),
                            painter = if(isAdded )
                                painterResource(R.drawable.group_107)
                            else painterResource(R.drawable.vector),
                            contentDescription = null,
                            tint = Color.Unspecified
                            )
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ProductCardView(){
//    ProductCard(
//        isAdd = false
//    )
//}