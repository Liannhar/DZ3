package com.example.my.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Map
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Radar
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.my.R
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.my.ui.screens.startscreen.StartScreenViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.my.PROFILE_SCREEN
import com.google.android.gms.common.internal.StringResourceValueReader
import kotlinx.coroutines.delay


private const val SPLASH_TIMEOUT = 1000L

@Composable
fun StartScreen(
    onAvatarButtonClicked: (String) -> Unit,
    onCenterButtonClicked: (String) -> Unit,
    onEventsButtonClicked:(String)->Unit,
    viewModel: StartScreenViewModel = hiltViewModel()
) {
    val infiniteTransition = rememberInfiniteTransition()
    val buttonSize by infiniteTransition.animateFloat(
        initialValue = 180f,
        targetValue = 200f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        val (centerButton, mainText, avatar, bottomPanel, settings,search) = createRefs()

        Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.constrainAs(avatar) {
            top.linkTo(parent.top, margin = 10.dp)
            end.linkTo(parent.end, margin = 10.dp)
        })
        {
            Box(
                modifier = Modifier
                    .clickable { viewModel.onAvatarClick(onAvatarButtonClicked) }
                    .clip(RoundedCornerShape(50))
                    .clip(CircleShape)
                    .background(Color.Red)
                    .size(40.dp)
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "User Avatar",
                    contentScale = ContentScale.Fit
                )
            }
        }
        Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.constrainAs(mainText) {
            top.linkTo(parent.top, margin = 10.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        {
            Box() {
                Text(text = stringResource(id = R.string.NameOfApp), fontSize = 25.sp)
            }
        }
        Box(contentAlignment = Alignment.Center, modifier = Modifier.constrainAs(centerButton) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .clip(CircleShape)
                    .size(buttonSize.dp)
                    .background(colorResource(id = R.color.mainColor))
                    .clickable { viewModel.onCenterButtonClick(onCenterButtonClicked) }
            )
            {

            }
        }
        Box(
            modifier = Modifier
                .constrainAs(bottomPanel) {
                    bottom.linkTo(parent.bottom)
                }
                .fillMaxWidth()
        )
        {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,

                modifier = Modifier
                    .background(colorResource(id = R.color.secondColorB))
                    .fillMaxWidth()
                    .size(40.dp)
            )
            {
                IconButton(
                    onClick = { viewModel.onEventClick(onEventsButtonClicked) },
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
                        contentDescription = "Loсalized description",
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
        Icon(
            Icons.Rounded.Search,
            contentDescription = "Localized description",
            modifier = Modifier
                .constrainAs(search) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
                .size(40.dp)
        )
        Box(contentAlignment = Alignment.Center,modifier = Modifier
            .constrainAs(settings) {
                bottom.linkTo(bottomPanel.top, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .width(100.dp)
            .height(25.dp)
            .clip(RoundedCornerShape(50))
            .clip(CircleShape)
            .background(Color.Gray)
            .clickable { }){
            Text(text = stringResource(id = R.string.settings), fontSize = 16.sp )
        }
    }

    LaunchedEffect(true) {
        delay(SPLASH_TIMEOUT)
        viewModel.onAppStart()
    }
}
