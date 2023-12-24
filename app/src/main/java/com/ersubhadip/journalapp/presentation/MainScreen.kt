package com.ersubhadip.journalapp.presentation

import android.annotation.SuppressLint
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import com.ersubhadip.journalapp.R
import com.ersubhadip.journalapp.presentation.components.SetupNavigation
import com.ersubhadip.journalapp.presentation.components.keyboardAsState
import com.ersubhadip.journalapp.presentation.utils.Destinations
import com.ersubhadip.journalapp.presentation.utils.MyPaddingValues
import com.ersubhadip.journalapp.presentation.utils.noRippleClickable
import com.ersubhadip.journalapp.ui.theme.Black
import com.ersubhadip.journalapp.ui.theme.PrimaryPink
import com.ersubhadip.journalapp.ui.theme.White
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Teleport
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun MainScreen(
    navController: NavHostController = rememberNavController(),
) {
    var selectedIndex by remember {
        mutableIntStateOf(1)
    }

    val navigationBarItems = remember {
        listOf(Destinations.DailyGoals, Destinations.DailyJournal, Destinations.Profiles)
    }

    Scaffold(
        modifier = Modifier
            .background(White),
        bottomBar = {
            AnimatedNavigationBar(
                modifier = Modifier
                    .padding(
                        horizontal = MyPaddingValues.MEDIUM,
                        vertical = MyPaddingValues.VERY_LARGE
                    )
                    .height(64.dp),
                selectedIndex = selectedIndex,
                ballColor = PrimaryPink,
                cornerRadius = shapeCornerRadius(36.dp),
                ballAnimation = Teleport(tween(500, easing = LinearEasing)),
                indentAnimation = Height(
                    indentWidth = 56.dp,
                    indentHeight = 12.dp,
                    animationSpec = tween(
                        1000,
                        easing = { OvershootInterpolator().getInterpolation(it) })
                )
            ) {
                navigationBarItems.forEach { item ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(PrimaryPink)
                            .noRippleClickable {
                                selectedIndex = navigationBarItems.indexOf(item)
                                navController.popBackStack()
                                navController.navigate(
                                    item.route,
                                    navOptions = NavOptions
                                        .Builder()
                                        .setLaunchSingleTop(true)
                                        .build(),
                                )
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(item.icon),
                            contentDescription = null,
                            tint = Black
                        )
                    }
                }
            }
        }
    ) {
        SetupNavigation(navController = navController)
    }
}

enum class BottomBarItems(val icons: Int) {
    Goals(icons = R.drawable.ic_goals),
    Journals(icons = R.drawable.ic_journals),
    Profiles(icons = R.drawable.ic_profile)
}


