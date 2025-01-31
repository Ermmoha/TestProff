package com.example.testproff.ui.screens.cardcategory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testproff.model.CardItem
import com.example.testproff.model.Category
import com.example.testproff.ui.components.CardColumn
import com.example.testproff.ui.components.CategoryRow
import com.example.testproff.ui.navigation.NavigationDestination
import com.example.testproff.ui.screens.cardcategory.CardCategoryDestination.category
import kotlinx.coroutines.flow.MutableStateFlow

object CardCategoryDestination: NavigationDestination {
    var category = MutableStateFlow(Category.ALL)
    override val title = "карточки"
    override val route = "card"
}

@Composable
fun CardCategoryScreen(
    viewModel: CardCategoryViewModel
){
    val state = viewModel.state.collectAsState()
    val categoryState by category.collectAsState()
    LaunchedEffect(Unit){
        viewModel.setCategory(categoryState)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        CategoryRow(
            selectedCategory = categoryState,
            onClick = {viewModel.setCategory(it)}
        )
        CardColumn(cardList = state.value.cards)
    }
}