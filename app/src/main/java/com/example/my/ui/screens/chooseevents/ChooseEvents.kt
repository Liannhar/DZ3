package com.example.my.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Adb
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Cable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.my.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChooseEvents() {
    val Modifiers= Modifier.padding(horizontal = 10.dp)
    Box()
    {
        Column()
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue), horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Icon(
                    Icons.Rounded.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { }
                )
            }
            Image(
                painter= painterResource(id = R.drawable.skates),
                contentDescription = stringResource(id= androidx.compose.ui.R.string.in_progress),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop,
            )
            Text("AAAAAAAAAAAAA", modifier = Modifier.padding(horizontal = 10.dp))
            Row(modifier = Modifier.padding(vertical = 20.dp))
            {
                Icon(
                    Icons.Rounded.Cable,
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(30.dp)
                )
                Text("DATE", modifier = Modifier.padding(horizontal = 10.dp))
            }
            Row()
            {
                Icon(
                    Icons.Rounded.Adb,
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(30.dp)
                )
                Text("Online", modifier = Modifier.padding(horizontal = 10.dp))
            }
                CardRandomHobby()
            Text("Opisanie")
        }
    }
}