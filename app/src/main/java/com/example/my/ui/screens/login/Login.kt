package com.example.my.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.my.common.composable.EmailField
import com.example.my.common.composable.PasswordField
import com.example.my.ui.screens.login.LoginViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun LoginScreen(
    profile: (String, String) -> Unit,
    signUp: (String, String) -> Unit,
    back:(String)->Unit,
    viewModel: LoginViewModel= hiltViewModel()
){
    val uiState by viewModel.uiState
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
                    .size(30.dp)
                    .clickable { viewModel.onBackClick(back) }
            )
        }
        if(uiState.isAnonymousAccount) {
            EmailField(uiState.email, viewModel::onEmailChange,
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 4.dp))
            PasswordField(uiState.password, viewModel::onPasswordChange,
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 4.dp))
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(RoundedCornerShape(30))
                    .fillMaxWidth()
                    .size(40.dp)
                    .padding(16.dp, 4.dp)
            )
            {
                Text(text = "Enter")
            }

            Button(onClick = { viewModel.onSignUpClick(signUp) },
                modifier = Modifier
                    .clip(RoundedCornerShape(30))
                    .fillMaxWidth()
                    .size(40.dp)
                    .padding(16.dp, 4.dp)
            )
            {
                Text(text = "Sign Up")
            }
        }
        else {
            viewModel.onProfile(profile)
        }

    }

}