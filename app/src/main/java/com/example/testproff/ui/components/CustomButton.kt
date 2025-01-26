package com.example.testproff.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    currentPage: Int,
    navigateToNextPage: () -> Unit
){
    val containerColor = if (currentPage == 0 || currentPage == 1 || currentPage ==2)
        Color.White
    else
        Color(72, 178, 231,)
    val contentColor = if (currentPage == 0 || currentPage == 1 || currentPage ==2)
        Color.Black
    else
        Color.White
    val title = if (currentPage == 0 ) "Начать" else if (currentPage == 1 || currentPage ==2) "Далее" else "Войти"
    Button(
        onClick = { navigateToNextPage() },
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        shape = RoundedCornerShape(14.dp),
        modifier = modifier.size(335.dp,50.dp)
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
            )
    }
}