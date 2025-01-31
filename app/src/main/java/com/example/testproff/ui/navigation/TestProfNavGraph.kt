package com.example.testproff.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.testproff.ui.components.maincomponents.CustomBottomNavigationBar
import com.example.testproff.ui.components.maincomponents.CustomTopBar
import com.example.testproff.ui.screens.HomeDestination
import com.example.testproff.ui.screens.HomeScreen
import com.example.testproff.ui.screens.OnBoardingDestination
import com.example.testproff.ui.screens.OnBoardingScreen
import com.example.testproff.ui.screens.PopularDestination
import com.example.testproff.ui.screens.PopularScreen
import com.example.testproff.ui.screens.RegisterDestination
import com.example.testproff.ui.screens.RegisterScreen
import com.example.testproff.ui.screens.SignInDestination
import com.example.testproff.ui.screens.SignInScreen
import com.example.testproff.ui.screens.cardcategory.CardCategoryDestination
import com.example.testproff.ui.screens.cardcategory.CardCategoryScreen
import com.example.testproff.ui.screens.cardcategory.CardCategoryViewModel
import kotlinx.coroutines.flow.update

@Composable
fun TestProfNavGraph(
    navController: NavHostController,
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val categoryState by CardCategoryDestination.category.collectAsState()

    Scaffold (
        topBar = {
            if (currentRoute != SignInDestination.route && currentRoute != OnBoardingDestination.route && currentRoute != RegisterDestination.route)
            CustomTopBar(
                title = when(currentRoute) {
                    HomeDestination.route -> "Главная"
                    CardCategoryDestination.route -> categoryState.categoryName
                    PopularDestination.route -> "Популярное"
                    else -> "NoName"
                },
                currentRoute = currentRoute,
                navigateToBack = { navController.popBackStack() }
            )
        },
        bottomBar = {
            if (currentRoute == HomeDestination.route)
                CustomBottomNavigationBar()
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = SignInDestination.route,
            modifier = Modifier.padding(it)
        ) {
            composable(route = SignInDestination.route) {
                SignInScreen(
                    navigateToRegScreen = {navController.navigate(RegisterDestination.route)},
                    navigateToOnBoardingScreen = {navController.navigate(OnBoardingDestination.route)}
                )
            }
            composable(route = OnBoardingDestination.route) {
                OnBoardingScreen(
                    navigateToHome = {navController.navigate(HomeDestination.route)}
                )
            }
            composable(route = HomeDestination.route){
                HomeScreen(
                    navigateToCategory = {category ->
                        navController.navigate(CardCategoryDestination.route)
                        CardCategoryDestination.category.update { category }
                    },
                    navigateToPopular = {navController.navigate(PopularDestination.route)}
                )
            }
            composable(route = CardCategoryDestination.route){
                val categoryViewModel = hiltViewModel<CardCategoryViewModel>()
                CardCategoryScreen(
                    viewModel = categoryViewModel
                )
            }
            composable(route = PopularDestination.route) {
                PopularScreen()
            }
            composable(route = RegisterDestination.route) {
                RegisterScreen(
                    navigateToSignInScreen = {navController.navigate(SignInDestination.route)}
                )
            }
        }

    }
}