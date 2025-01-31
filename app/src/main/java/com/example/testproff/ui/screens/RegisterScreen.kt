package com.example.testproff.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testproff.R
import com.example.testproff.ui.components.CustomTextField
import com.example.testproff.ui.components.maincomponents.CustomButton
import com.example.testproff.ui.navigation.NavigationDestination

object  RegisterDestination: NavigationDestination {
    override val title = "Ругистрация"
    override val route = "registr"
}

@Composable
fun RegisterScreen(
    navigateToSignInScreen:() -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("")}
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(20.dp, 100.dp)
                .height(416.dp)
                .width(335.dp)
        ) {
            Text(
                text = "Регистрация",
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
                    .height(400.dp)
                    .width(335.dp)
            ) {
                CustomTextField(
                    title = "Ваше имя",
                    example = "xxxxxxxx",
                    value = name,
                    onValueChange = { name = it },
                    isPassword = false
                )
                CustomTextField(
                    title = "Email",
                    example = "xyz@gmail.com",
                    value = email,
                    onValueChange = { email = it },
                    isPassword = false
                )
                CustomTextField(
                    title = "Пароль",
                    example = "••••••••",
                    value = password,
                    onValueChange = { password = it },
                    isPassword = true
                )
                Row(
                    modifier = Modifier.height(220.dp)
                ) {
                    Icon(
                        modifier = Modifier.padding(top = 8.dp),
                        painter = painterResource(R.drawable.yes),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                    TextButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.height(50.dp)
                    ) {
                        Text(
                            text = "Даю согласие на обработку \nперсональных данных",
                            color = Color(106, 106, 106),
                            maxLines = 2,
                            lineHeight = 16.sp,
                            fontSize = 16.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                CustomButton(
                    containerColor = Color(72, 178, 231,),
                    contentColor = Color.White,
                    title = "Зарегистрироваться",
                    onClick = navigateToSignInScreen,
                    )
            }
        }
        TextButton(
            onClick = { navigateToSignInScreen() },
            modifier = Modifier
                .width(335.dp)
                .padding(bottom = 50.dp)
        ) {
            Text(
                text = "Есть аккаунт? ",
                fontSize = 16.sp,
                color = Color(112, 123, 129,)
            )
            Text(
                text = "Войти",
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}