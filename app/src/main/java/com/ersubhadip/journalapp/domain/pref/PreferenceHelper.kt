package com.ersubhadip.journalapp.domain.pref

import splitties.preferences.Preferences

object PreferenceHelper : Preferences("journal-data") {

    var userName by StringPref(PreferenceKey.NAME_KEY, "")
    var doesUserExists by BoolPref(PreferenceKey.IS_USER_EXISTS_KEY, false)
}