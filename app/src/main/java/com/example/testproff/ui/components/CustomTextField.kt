package com.example.testproff.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testproff.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    title: String,
    example: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean
){
    var transformation by remember { mutableStateOf(true) }
    Text(
        text = title,
        fontSize = 16.sp,
    )
    Spacer (modifier = Modifier.height(12.dp))
    TextField(
        modifier = Modifier
            .width(335.dp)
            .height(48.dp),
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = if (isPassword) {
            KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            )
        } else {
            KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            )
        },
        maxLines = 1,
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            containerColor = Color(247, 247, 249)
        ),
        placeholder = {
            Text(
                text = example,
                fontSize = 14.sp,
                color = Color(106, 106, 106)
            )
        },
        trailingIcon = {
            if (isPassword) {
                IconButton(onClick = { transformation = !transformation }) {
                    Icon(
                        painter = painterResource(id = R.drawable.password),
                        contentDescription = null,
                        Modifier.size(16.37.dp,13.dp),
                        tint = if (transformation)
                            Color(106, 106, 106,)
                        else Color(26, 37, 48,)
                    )
                }
            }
        },
        visualTransformation = if (transformation && isPassword) PasswordVisualTransformation()
        else VisualTransformation.None,
    )
}