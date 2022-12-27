package com.example.my

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Headphones
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import  androidx.lifecycle.viewmodel.compose.viewModel
import com.example.my.ui.screens.profile.ProfileViewModel


@Composable
fun ProfileScreen(
    restartApp:(String)->Unit,
    onBackButtonClicked:(String)->Unit,
    viewModel: ProfileViewModel = hiltViewModel()
){
    val Modifiers = Modifier.padding(top = 10.dp)
    Column( horizontalAlignment= Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        )
    {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue))
        {
            Icon(
                Icons.Rounded.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .size(30.dp).clickable { viewModel.onBackButtonClick(onBackButtonClicked) }
            )
        }
        Box (modifier = Modifiers
            .clip(RoundedCornerShape(100))
            .clip(CircleShape)
            .background(Color.Red)
            .size(200.dp)
        ){
        }
        Button(onClick = {  },
            modifier = Modifiers
                .clip(RoundedCornerShape(30))
                .fillMaxWidth()
                .size(40.dp)
                ) {
            Text(text = "settings")
        }
        Button(onClick = { viewModel.onSignOutClick(restartApp) },
            modifier = Modifiers
                .clip(RoundedCornerShape(30))
                .fillMaxWidth()
                .size(40.dp)
                )
        {
            Text(text = "Exit")
        }
    }

}