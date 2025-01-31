package com.example.testproff

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.testproff.ui.navigation.TestProfNavGraph

@Composable
fun ProfTestApp(
    navController: NavHostController = rememberNavController()
){
    TestProfNavGraph(
        navController = navController
    )
}