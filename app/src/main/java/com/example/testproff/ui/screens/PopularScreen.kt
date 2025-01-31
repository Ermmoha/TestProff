package com.example.testproff.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.testproff.model.CardItem
import com.example.testproff.model.Category
import com.example.testproff.ui.components.CardColumn
import com.example.testproff.ui.components.CategoryRow
import com.example.testproff.ui.navigation.NavigationDestination

object PopularDestination: NavigationDestination{
    override val title = "Популярное"
    override val route = "popular"
}

@Composable
fun PopularScreen(){
     val cardList = listOf(
        CardItem(isAdd = true, isLike = true, category = Category.RUNNING),
        CardItem(isAdd = true, isLike = true, category = Category.RUNNING),
        CardItem(isAdd = true, isLike = true, category = Category.RUNNING),
        CardItem(isAdd = true, isLike = true, category = Category.RUNNING),
        CardItem(isAdd = true, isLike = true, category = Category.RUNNING),
        CardItem(isAdd = true, isLike = true, category = Category.OUTDOOR),
        CardItem(isAdd = true, isLike = true, category = Category.OUTDOOR),
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        CardColumn(cardList = cardList)
    }
}