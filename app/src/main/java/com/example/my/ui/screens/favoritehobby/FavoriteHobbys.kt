package com.example.my.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Map
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Radar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FavoriteHobbys() {
    val Modifiers= Modifier.padding(horizontal = 10.dp)
    Box()
    {
        Column(verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize())
        {
            if (1==1) {
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Text("What is it?",
                        color=Color.Red,
                        fontSize=30.sp
                    )
                    Text("Go to the selection of cases", modifier = Modifier.clickable {  })
                }

            }
            else{
                //LazyColumn(){
                // items(List<Cards>){ cards ->
                //                CardEvents(cards)
                //            }}
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,

                modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(40.dp)
            )
            {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(40.dp)
                ) {
                    Icon(
                        Icons.Rounded.Menu,
                        contentDescription = "Localized description",
                        modifier = Modifier.size(40.dp)
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(40.dp)
                )
                {
                    Icon(
                        Icons.Rounded.Map,
                        contentDescription = "Localized description",
                        modifier = Modifier.size(40.dp)
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(40.dp)
                ) {
                    Icon(
                        Icons.Rounded.Radar,
                        contentDescription = "Localized description",
                        modifier = Modifier.size(40.dp)
                    )
                }

            }
        }
    }
}