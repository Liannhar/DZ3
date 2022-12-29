package com.example.my.ui.screens.randomhobby

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Headphones
import androidx.compose.material.icons.rounded.MonitorHeart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.my.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.my.model.Event
import com.example.my.model.Group
import com.example.my.model.Hobby
import com.example.my.ui.screens.CardEvents
import com.example.my.ui.screens.CardGroups
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

@OptIn(ExperimentalLifecycleComposeApi::class, ExperimentalGlideComposeApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RandomHobbyScreen(
    onBackButtonClicked: (String, String) -> Unit,
    viewModel: RandomHobbyViewModel= hiltViewModel())
{
    val currentHobby = viewModel.RandomHobby().collectAsStateWithLifecycle(initialValue = Hobby("Basketball"))
    val eventList = currentHobby.value?.let { viewModel.EventList(it) }?.collectAsStateWithLifecycle(emptyList())
    val groupList = currentHobby.value?.let { viewModel.GroupList(it) }?.collectAsStateWithLifecycle(emptyList())
    val Modifiers = Modifier.padding(start=10.dp, top = 10.dp)


    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    )
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
                    .clickable { viewModel.onBackButtonClick(onBackButtonClicked) }
            )
            Text(
                currentHobby.value!!.title,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Icon(
                Icons.Rounded.MonitorHeart,
                contentDescription = "Like",
                modifier = Modifier
                    .size(30.dp)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.skates),
            contentDescription = "",
            contentScale = ContentScale.Fit
        )
        //GlideImage(model =  painterResource(id = R.drawable.skates), contentDescription = "",contentScale = ContentScale.Fit)
        Text(text = stringResource(id = R.string.events), modifier = Modifiers)
        LazyRow {
            if (eventList != null) {
                items(eventList.value, key = { it.id }) { event ->
                    CardEvents(
                        event = event)
                }
            }
        }
        Text(text = stringResource(id = R.string.groups), modifier = Modifiers)
        LazyRow {
            if (groupList != null) {
                items(groupList.value, key = { it.id }) { group ->
                    CardGroups(
                        group = group
                    )
                }
            }
        }
    }
}