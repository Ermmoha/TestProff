package com.example.testproff.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testproff.model.Category

@Composable
fun CategoryRow(
    selectedCategory: Category?,
    onClick:(Category) -> Unit
){
    val categoryList = Category.values()
    Text(
        text = "Категории",
        fontSize = 16.sp,
        modifier = Modifier
            .padding(start = 20.dp, bottom = 20.dp)
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(categoryList){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .shadow(
                        elevation = 1.dp,
                        shape = RoundedCornerShape(7.dp)
                    )
                    .size(115.dp, 42.dp)
                    .background(if (it == selectedCategory)
                        Color(72, 178, 231,)
                    else {Color(255, 255, 255)},
                        RoundedCornerShape(7.dp))
                    .clickable { onClick(it) }
            ){
                var categoryName by remember { mutableStateOf(it.categoryName) }
                Text(
                    text = categoryName,
                    fontSize = 12.sp,
                )
            }
        }
    }
}