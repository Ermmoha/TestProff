package com.example.testproff.ui.components.maincomponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testproff.R
import com.example.testproff.ui.screens.cardcategory.CardCategoryDestination
import com.example.testproff.ui.screens.HomeDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    title: String,
    currentRoute: String?,
    navigateToBack:() -> Unit
){
    TopAppBar(
        title = {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            when(currentRoute) {
                HomeDestination.route ->
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    painter = painterResource(R.drawable.hamburger),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(25.dp, 18.dp)
                    )
                }
                else ->
                    IconButton(
                        onClick = { navigateToBack() },
                        modifier = Modifier.align(Alignment.CenterStart)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.back),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier.size(44.dp, 44.dp)
                        )
                    }
            }
            Text(
                text = title,
                fontSize = if (currentRoute == HomeDestination.route) 32.sp else 16.sp,
                modifier = Modifier
                    .align(Alignment.Center)
                )
            if (currentRoute == HomeDestination.route) {
                Icon(
                    painter = painterResource(R.drawable.highlight_05),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .padding(end = 130.dp, bottom = 30.dp)

                )
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(50.dp, 53.dp)
                    .align(Alignment.CenterEnd)
            ) {
                if (currentRoute != CardCategoryDestination.route)
                Icon(
                    painter = if (currentRoute  == HomeDestination.route)
                        painterResource(R.drawable.group_27)
                    else painterResource(R.drawable.heart)
                        ,
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(44.dp,44.dp)

                )
            }
            }
        })
}

//@Composable
//@Preview(showBackground = true)
//fun CustomTopBarPreview(){
//    CustomTopBar()
//}