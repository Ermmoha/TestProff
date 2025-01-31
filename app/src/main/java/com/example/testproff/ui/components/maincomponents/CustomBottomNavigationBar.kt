package com.example.testproff.ui.components.maincomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.testproff.R

@Composable
fun CustomBottomNavigationBar() {
    var selectedItemIndex by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp)
            .background(Color.Transparent),
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(115.dp),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(R.drawable.bottombar),
            contentDescription = null
        )


        Row(
            modifier = Modifier
                .height(140.dp)
                .fillMaxWidth(),
        ) {
            NavigationBarItem(
                modifier = Modifier
                    .padding(top = 20.dp, start = 15.dp),
                selected = selectedItemIndex == 0,
                onClick = { selectedItemIndex = 0 },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(72, 178, 231),
                    unselectedIconColor = Color(112, 123, 129),
                    indicatorColor = Color.White
                ),
                icon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(R.drawable.home),
                        contentDescription = null
                    )
                }
            )

            NavigationBarItem(
                modifier = Modifier
                    .padding(top = 20.dp, start = 15.dp),
                selected = selectedItemIndex == 1,
                onClick = { selectedItemIndex = 1 },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(72, 178, 231),
                    unselectedIconColor = Color(112, 123, 129),
                    indicatorColor = Color.White
                ),
                icon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(R.drawable.heartnav),
                        contentDescription = null
                    )
                }
            )

            IconButton(
                modifier = Modifier
                    .size(106.dp)
                    .padding(bottom = 10.dp),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    modifier = Modifier
                        .size(106.dp),
                    painter = painterResource(R.drawable.group_123),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }

            NavigationBarItem(
                modifier = Modifier
                    .padding(top = 20.dp, start = 15.dp),
                selected = selectedItemIndex == 2,
                onClick = { selectedItemIndex = 2 },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(72, 178, 231),
                    unselectedIconColor = Color(112, 123, 129),
                    indicatorColor = Color.White
                ),
                icon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(R.drawable.notif),
                        contentDescription = null,
                    )
                }
            )

            NavigationBarItem(
                modifier = Modifier
                    .padding(top = 20.dp, start = 15.dp),
                selected = selectedItemIndex == 3,
                onClick = { selectedItemIndex = 3 },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(72, 178, 231),
                    unselectedIconColor = Color(112, 123, 129),
                    indicatorColor = Color.White
                ),
                icon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(R.drawable.person),
                        contentDescription = null
                    )
                }
            )
        }
    }
}

