package com.example.my.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.my.R
import com.example.my.model.Event
import com.example.my.model.Group

@Composable
fun CardGroups(group : Group)
{
    Box()
    {
        Box(modifier = Modifier.fillMaxWidth().padding(8.dp).size(200.dp).border(2.dp, Color.Green), contentAlignment = Alignment.BottomStart)
        {
            Image(
                painter= painterResource(id = R.drawable.skates),
                contentDescription = stringResource(id= androidx.compose.ui.R.string.in_progress),
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop)
            Text(
                text=group.name,
                modifier = Modifier,
                style = MaterialTheme.typography.h6
            )
        }
    }
}