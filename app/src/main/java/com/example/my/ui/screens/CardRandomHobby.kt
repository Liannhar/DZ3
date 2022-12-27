package com.example.my.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*

import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.my.R


@Preview(showSystemUi = true,
showBackground = true)
@Composable
fun CardRandomHobby()
{
    Box()
    {
        Card(modifier = Modifier.fillMaxWidth().padding(8.dp).size(200.dp).border(2.dp,Color.Green), elevation = 4.dp)
        {
                Image(
                    //painter = painterResource(Ca  rds.imageResourceId),
                    //contentDescription = stringResource(Cards.stringResourceId),
                    painter=painterResource(id = R.drawable.skates),
                    contentDescription = stringResource(id= androidx.compose.ui.R.string.in_progress),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    //text = stringResource(Cards.stringResourceId),
                    text="AAA",
                    modifier = Modifier.align(Alignment.CenterEnd),
                    style = MaterialTheme.typography.h6
                )
        }
    }

}