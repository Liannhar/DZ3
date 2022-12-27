package com.example.my

import android.content.res.Resources
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.my.ui.screens.Events
import com.example.my.ui.screens.LoginScreen
import com.example.my.ui.screens.randomhobby.RandomHobbyScreen
import com.example.my.ui.screens.StartScreen
import com.example.my.ui.screens.signup.SignUpScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun MyApp(modifier: Modifier = Modifier){
    val appState= rememberAppState()
    Scaffold(scaffoldState = appState.scaffoldState
    ) { innerPadding ->
        NavHost(navController = appState.navController,
            startDestination = START_SCREEN,
            modifier = Modifier.padding(innerPadding)
        )
        {
            NavigationApp(appState)
        }
    }
}

fun NavGraphBuilder.NavigationApp(appState: MakeItSoAppState) {
    composable(START_SCREEN) {
        StartScreen(onAvatarButtonClicked = { route -> appState.navigate(route) }, onCenterButtonClicked={route->(appState.navigate(route))}, onEventsButtonClicked = {route->(appState.navigate(route))})
    }

    composable(PROFILE_SCREEN) {
        ProfileScreen(restartApp = {route -> appState.clearAndNavigate(route)}, onBackButtonClicked = {route -> appState.navigate(route)})
    }

    composable(LOGIN_SCREEN) {
        LoginScreen(profile = { route, popUp -> appState.navigateAndPopUp(route, popUp) },signUp={ route, popUp -> appState.navigateAndPopUp(route, popUp) },back={ route -> appState.navigate(route) })
    }

    composable(SIGN_UP_SCREEN) {
        SignUpScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
    }
    composable(RANDOMHOBBY_SCREEN){
        RandomHobbyScreen(onBackButtonClicked = {route, popUp -> appState.navigateAndPopUp(route, popUp)})
    }
    composable(EVENT_SCREEN){
        Events(onBackButtonClicked ={ route -> appState.navigate(route) })
    }
}

@Composable
fun rememberAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    resources: Resources = resources(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) =
    remember(scaffoldState, navController, resources, coroutineScope) {
        MakeItSoAppState(scaffoldState, navController,resources, coroutineScope)
    }

@Composable
@ReadOnlyComposable
fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}
