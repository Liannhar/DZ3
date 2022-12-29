package com.example.my.ui.screens


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.my.R
import com.example.my.model.Event
import com.example.my.ui.CardViewModel
import com.example.my.ui.screens.randomhobby.RandomHobbyViewModel


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CardEvents(event : Event,viewModel: CardViewModel= hiltViewModel())
{
    Box()
    {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .size(200.dp)
            .border(2.dp, Color.Green),
            contentAlignment = Alignment.BottomStart)
        {

            GlideImage(
                model = event.image,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = {}),
                contentScale = ContentScale.Crop,
            contentDescription = "Event")

            Text(
                text=event.title,
                modifier = Modifier,
                style = MaterialTheme.typography.h6
            )
        }
    }
}