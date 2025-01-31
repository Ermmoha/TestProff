package com.example.testproff.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testproff.model.CardItem
import com.example.testproff.ui.components.maincomponents.ProductCard

@Composable
fun CardColumn(
    cardList: List<CardItem>
){
    LazyVerticalGrid(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(20.dp,10.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(cardList){
            ProductCard(
                painter = it.painter,
                name = it.name,
                title = it.title,
                price = it.price,
                isLike = it.isLike,
                isAdd = it.isAdd


            )
        }
    }
}