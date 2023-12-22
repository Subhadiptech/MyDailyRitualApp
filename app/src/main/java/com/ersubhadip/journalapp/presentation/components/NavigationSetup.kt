package com.ersubhadip.journalapp.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ersubhadip.journalapp.presentation.dailygoalsscreen.DailyGoalsScreen
import com.ersubhadip.journalapp.presentation.journalscreen.JournalScreenParent
import com.ersubhadip.journalapp.presentation.profilescreen.ProfileScreen
import com.ersubhadip.journalapp.presentation.utils.Destinations

@Composable
fun SetupNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destinations.DailyJournal.route) {
        composable(Destinations.DailyGoals.route) {
            DailyGoalsScreen()
        }

        composable(Destinations.DailyJournal.route) {
            JournalScreenParent()
        }

        composable(Destinations.Profiles.route) {
            ProfileScreen()
        }
    }
}