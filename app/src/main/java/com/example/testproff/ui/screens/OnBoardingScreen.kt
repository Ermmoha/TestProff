package com.example.testproff.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testproff.R
import com.example.testproff.ui.components.CustomButton
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(){
    val pageCount = 3
    val pagerState = rememberPagerState { pageCount }
    val currentPage = pagerState.currentPage
    val scope = rememberCoroutineScope()
    val navigateToNextPage: () -> Unit = {
        scope.launch {
            pagerState.scrollToPage(currentPage + 1)
        }
    }
    Box(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(72, 178, 231,),
                        Color(68, 169, 220,),
                        Color(43, 107, 139,)
                    )
                )
            )
            .fillMaxSize(),

    ){
        HorizontalCardsPager(
            pagerState = pagerState,
            currentPage = currentPage
        )
        ProgressBar(
            currentPage = currentPage,
            pageCount = pageCount
        )

        CustomButton(
            currentPage = currentPage,
            navigateToNextPage = navigateToNextPage,
            modifier = Modifier
                .padding(bottom = 46.dp)
                .align(Alignment.BottomCenter)
        )
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalCardsPager(
    pagerState: PagerState,
    currentPage: Int
){
    HorizontalPager(
        state = pagerState,
        userScrollEnabled = false,
        modifier = Modifier.fillMaxSize()
    ) {
        var title = ""
        var miniTitle = ""
        var painter = painterResource(R.drawable.image1)
        when(currentPage){
            0 -> { title = "ДОБРО ПОЖАЛОВАТЬ";  painter = painterResource(R.drawable.image1)}
            1 -> { title = "Начнем путешествие";  painter = painterResource(R.drawable.image2); miniTitle = "Умная, великолепная и модная коллекция Изучите сейчас"}
            2 -> { title = "У Вас Есть Сила, Чтобы";  painter = painterResource(R.drawable.image3); miniTitle = "В вашей комнате много красивых и привлекательных растений"}
        }
        OnBoardingComponents(
            title = title,
            painter = painter,
            currentPage = currentPage,
            miniTitle = miniTitle
        )
    }
}

@Composable
fun OnBoardingComponents(
    title: String,
    miniTitle: String,
    painter: Painter,
    currentPage: Int
){
    var isVisible by remember { mutableStateOf(false) }
    var padding = 0.dp
    LaunchedEffect(currentPage) {
        isVisible = false
        delay(200)
        isVisible = true
    }
    if(currentPage == 0) padding = 55.dp else padding = 37.dp
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()

    ) {
        if (currentPage == 0) {
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(tween(700)),
                exit = fadeOut(tween(700))
            ) {
                Text(
                    modifier = Modifier
                        .padding(70.dp, 50.dp)
                        .size(267.dp, 62.dp),
                    text = title,
                    fontSize = 30.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 30.sp
                )
            }
        }
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(tween(700)),
            exit = fadeOut(tween(700))
        ) {
            Image(
                painter = painter,
                contentDescription = null,

                modifier = Modifier
                    .padding(top = padding,)
                    .fillMaxWidth()
                    .height(316.dp)
            )
        }
        if (currentPage != 0)
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(tween(700)),
                exit = fadeOut(tween(700))
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 50.dp)
                        .size(315.dp, 89.dp),
                    text = title,
                    fontSize = 34.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 44.sp
                )
            }
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(tween(700)),
            exit = fadeOut(tween(700))
        ) {
            Text(
                modifier = Modifier
                    .padding(12.dp, 25.dp)
                    .size(315.dp, 48.dp),
                text = miniTitle,
                fontSize = 16.sp,
                color = Color(216, 216, 216,),
                textAlign = TextAlign.Center,
                lineHeight = 24.sp
            )
        }
    }
}

@Composable
fun ProgressBar(
    currentPage: Int,
    pageCount: Int
){
    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(top = 590.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pageCount) { iteration ->
            val color = if (currentPage == iteration) Color.White else Color(43, 107, 139,)
            val width = if (currentPage == iteration) 43.dp else 28.dp
            Box(
                modifier = Modifier
                    .animateContentSize(tween())
                    .padding(6.dp)
                    .background(color, RoundedCornerShape(5.dp))
                    .width(width)
                    .height(5.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview(){
    OnBoardingScreen()
}