package com.example.testproff.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testproff.ui.components.CustomButton
import com.example.testproff.ui.components.CustomTextField

@Composable
fun SignInScreen() {
    var email by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(20.dp, 121.dp)
                .height(416.dp)
                .width(335.dp)
        ) {
            Text(
                text = "Привет!",
                fontSize = 32.sp,
            )
            Text(
                modifier = Modifier
                    .height(48.dp)
                    .width(315.dp),
                text = "Заполните Свои Данные Или \nПродолжите Через Социальные Медиа",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color(112, 123, 129,)
            )
            Column(
                modifier = Modifier
                    .padding(top = 35.dp)
                    .height(292.dp)
                    .width(335.dp)
            ) {
                CustomTextField(
                    title = "Email",
                    example = "xyz@gmail.com",
                    value = email,
                    onValueChange = {email = it},
                    isPassword = false
                    )
                CustomTextField(
                    title = "Пароль",
                    example = "••••••••",
                    value = password,
                    onValueChange = {password = it},
                    isPassword = true
                    )
                TextButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(
                        text = "Восстановить",
                        color = Color(112, 123, 129,),
                        fontSize = 12.sp
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                CustomButton(
                    currentPage = 4,
                    navigateToNextPage = {}
                )
            }
        }
        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(335.dp)
                .padding(bottom = 50.dp)
        ) {
            Text(
                text = "Вы впервые? ",
                fontSize = 16.sp,
                color = Color(112, 123, 129,)
            )
            Text(
                text = "Создать пользователя",
                fontSize = 16.sp,
                color = Color.Black
                )
        }
    }
}





@Preview(showBackground = true)
@Composable
fun SignInPreview(){
    SignInScreen()
}
