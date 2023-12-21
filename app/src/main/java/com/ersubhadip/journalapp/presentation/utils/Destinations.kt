package com.ersubhadip.journalapp.presentation.utils

import com.ersubhadip.journalapp.R

sealed class Destinations(val route: String, val icon: Int) {
    data object DailyGoals: Destinations(route = "dailygoals", icon = R.drawable.ic_goals,)
    data object DailyJournal: Destinations(route = "dailyjournal", icon = R.drawable.ic_journals,)
    data object Profiles: Destinations(route = "profiles", icon = R.drawable.ic_profile,)
}