package com.example.testproff.model


import com.example.testproff.R

data class CardItem(
    val name: String = "Nike Air Max",
    val title: String = "BEST SELLER",
    val painter: Int = R.drawable.nike,
    val price: String = "₽752.00",
    val isLike: Boolean,
    val isAdd: Boolean,
    val category: Category
)

enum class Category(val categoryName: String) {
    ALL("Все"),
    OUTDOOR("Outdoor"),
    TENNIS("Tennis"),
    RUNNING("Running")
    
}