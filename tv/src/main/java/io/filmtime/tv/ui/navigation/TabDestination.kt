package io.filmtime.tv.ui.navigation

import io.filmtime.tv.ui.navigation.TabDestination.HomeScreen
import io.filmtime.tv.ui.navigation.TabDestination.MoviesScreen
import io.filmtime.tv.ui.navigation.TabDestination.SearchScreen
import io.filmtime.tv.ui.navigation.TabDestination.SettingsScreen
import io.filmtime.tv.ui.navigation.TabDestination.ShowsScreen
import kotlinx.serialization.Serializable

sealed interface TabDestination {
  @Serializable
  data object HomeScreen : TabDestination

  @Serializable
  data object ShowsScreen : TabDestination

  @Serializable
  data object MoviesScreen : TabDestination

  @Serializable
  data object SearchScreen : TabDestination

  @Serializable
  data object SettingsScreen : TabDestination
}

fun TabDestination.toTabItem() =
  when (this) {
    HomeScreen -> TabItem.Home
    MoviesScreen -> TabItem.Movies
    SearchScreen -> TabItem.Search
    SettingsScreen -> TabItem.Settings
    ShowsScreen -> TabItem.Shows
  }
