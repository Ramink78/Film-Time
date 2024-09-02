package io.filmtime.tv.ui.navigation

import androidx.navigation.NavBackStackEntry

fun NavBackStackEntry?.tabDestination() =
  this?.destination?.route?.substringBefore("?")?.substringBefore("/")
    ?.substringAfterLast(".")?.let {
      when (it) {
        TabDestination.SearchScreen::class.simpleName -> TabDestination.SearchScreen
        TabDestination.SettingsScreen::class.simpleName -> TabDestination.SettingsScreen
        TabDestination.ShowsScreen::class.simpleName -> TabDestination.ShowsScreen
        TabDestination.MoviesScreen::class.simpleName -> TabDestination.MoviesScreen
        else -> TabDestination.HomeScreen
      }
    } ?: TabDestination.HomeScreen
