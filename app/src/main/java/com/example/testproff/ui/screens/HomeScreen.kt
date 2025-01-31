package com.example.testproff.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testproff.R
import com.example.testproff.model.CardItem
import com.example.testproff.model.Category
import com.example.testproff.ui.components.CardColumn
import com.example.testproff.ui.components.CategoryRow
import com.example.testproff.ui.navigation.NavigationDestination

object HomeDestination: NavigationDestination{
    override val title = "Главная"
    override val route = "home"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToCategory:(Category) -> Unit,
    navigateToPopular:() -> Unit
){
    var selectedCategory by remember { mutableStateOf<Category?>(null) }
    Column {
        val cardList = listOf(
            CardItem( isLike = false, isAdd = false, category = Category.RUNNING),
            CardItem(isLike = false, isAdd = true, category = Category.OUTDOOR)
        )
        SearchRow()
        CategoryRow(
            selectedCategory = selectedCategory,
            onClick = {
                selectedCategory = it
                navigateToCategory(it)
            }
        )
        RowAll(category = "Популярное", navigateToAll = navigateToPopular)
        CardColumn(cardList = cardList)
        RowAll(category = "Акции", navigateToAll = {})
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 5.dp)
        ) {
            Card(
                onClick = { },
                modifier = Modifier
                    .height(95.dp)
                    .width(335.dp)
                    .padding(3.dp)
                    .shadow(
                        elevation = 15.dp
                    )
            ) {
                Box(modifier = Modifier.fillMaxSize()){
                        Image(
                            painterResource(R.drawable.nikebunner),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                }
            }
        }
    }
}

@Composable
fun RowAll(
    category: String,
    navigateToAll:() -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()) {
        Text(
            text = category,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(start = 20.dp, top = 10.dp)
        )
        TextButton(
            modifier = Modifier
                .padding(end = 20.dp)
                .align(Alignment.BottomEnd),
            onClick = { navigateToAll() }) {
            Text(
                text = "Все",
                fontSize = 12.sp,
                color = Color(72, 178, 231,),
                modifier = Modifier
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchRow(){
    var searchValue by remember { mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 10.dp)
    ) {
        TextField(
            value = searchValue,
            onValueChange = { searchValue = it },
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(14.dp)
                )
                .size(269.dp, 52.dp),
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                containerColor = Color(255, 255, 255)
            ),
            singleLine = true,
            placeholder = {
                Text(
                    text = "Поиск",
                    fontSize = 12.sp,
                    color = Color(106,106,106)
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.search),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp,24.dp),
                    tint = Color.Unspecified
                )
            }

        )
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(start = 12.dp)
                .size(56.dp, 56.dp)

        ) {
            Icon(
                painter = painterResource(R.drawable.group_1000000743),
                contentDescription = null,
                modifier = Modifier
                    .size(52.dp,52.dp),
                tint = Color.Unspecified
            )
        }
    }
}



