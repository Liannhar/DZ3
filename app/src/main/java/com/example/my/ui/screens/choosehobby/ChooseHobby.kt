package com.example.my.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChooseHobby(

) {
    Box(modifier = Modifier
        .fillMaxSize()
        .border(2.dp, Color.Green))
    {
        Column {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp)
                .clip(RoundedCornerShape(50))
                .clip(CircleShape)
                .background(Color.Gray)
                .clickable { } )
            {
                Icon(
                    Icons.Rounded.Search,
                    contentDescription = "Search",
                    modifier = Modifier.size(30.dp)
                )
            }
            LazyColumn() {
                //Searcher
            }
        }
    }
}