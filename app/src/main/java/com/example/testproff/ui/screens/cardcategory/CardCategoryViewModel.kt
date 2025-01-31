package com.example.testproff.ui.screens.cardcategory

import androidx.lifecycle.ViewModel
import com.example.testproff.model.CardItem
import com.example.testproff.model.Category
import com.example.testproff.ui.screens.cardcategory.CardCategoryDestination.category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CardCategoryViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(CardCategoryState())
    val state = _state.asStateFlow()

    private val cardList = listOf(
        CardItem(isAdd = true, isLike = true, category = Category.RUNNING),
        CardItem(isAdd = true, isLike = true, category = Category.RUNNING),
        CardItem(isAdd = true, isLike = true, category = Category.RUNNING),
        CardItem(isAdd = true, isLike = true, category = Category.RUNNING),
        CardItem(isAdd = true, isLike = true, category = Category.RUNNING),
        CardItem(isAdd = true, isLike = true, category = Category.OUTDOOR),
        CardItem(isAdd = true, isLike = true, category = Category.OUTDOOR),
        CardItem(isAdd = true, isLike = true, category = Category.TENNIS),
        CardItem(isAdd = true, isLike = true, category = Category.TENNIS),
        CardItem(isAdd = true, isLike = true, category = Category.TENNIS)
    )

    init {
        filterCards(category.value)
    }

    private fun filterCards(selectedCategory: Category) {
        val filteredCards = if (selectedCategory == Category.ALL) {
            cardList
        } else {
            cardList.filter { it.category == selectedCategory }
        }
        _state.update { it.copy(cards = filteredCards) }
    }

    fun setCategory(category: Category) {
        CardCategoryDestination.category.update {
            return@update category
        }
        filterCards(category)
    }

}
