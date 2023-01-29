package com.example.my.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.my.NameofHobbies
import com.example.my.R
import com.example.my.ui.screens.events.EventsViewModel
import com.example.my.ui.screens.randomhobby.RandomHobbyViewModel


@Composable
fun Events(onBackButtonClicked: (String) -> Unit,
           viewModel: EventsViewModel = hiltViewModel()
) {
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
                        .clickable { viewModel.onBackButtonClick(onBackButtonClicked) }
                )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.secondColorA)),horizontalArrangement = Arrangement.SpaceBetween)
            {
                Text(text = stringResource(id = R.string.allEvents) , modifier = Modifiers)
                Text(text = stringResource(id = R.string.goEvents), modifier = Modifiers)
                Text(text = stringResource(id = R.string.SaveEvents), modifier = Modifiers)
            }
            LazyColumn(){

                for (count in NameofHobbies.indices)
                {
//                    /val currentHobby = viewModel.getHobby(count)
//                    val eventList = currentHobby.value?.let { viewModel.EventList(it) }?.collectAsStateWithLifecycle(emptyList())
//                    if (eventList != null) {
//                        items(eventList.value, key = { it.id }) { event ->
//                            CardEvents(
//                                event = event
//                            )
//                        }
//                    }
                }

            }


        }
    }
}