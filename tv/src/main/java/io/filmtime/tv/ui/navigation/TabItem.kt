package io.filmtime.tv.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Subscriptions
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Movie
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Subscriptions
import androidx.compose.ui.graphics.vector.ImageVector
import io.filmtime.tv.R

enum class TabItem(
  val tabDestination: TabDestination,
  val selectedIcon: ImageVector,
  val unselectedIcon: ImageVector,
  val title: Int,
) {
  Home(
    tabDestination = TabDestination.HomeScreen,
    selectedIcon = Icons.Rounded.Home,
    unselectedIcon = Icons.Outlined.Home,
    title = R.string.tab_home,
  ),
  Movies(
    tabDestination = TabDestination.MoviesScreen,
    selectedIcon = Icons.Rounded.Movie,
    unselectedIcon = Icons.Outlined.Movie,
    title = R.string.tab_movies,
  ),
  Shows(
    tabDestination = TabDestination.ShowsScreen,
    selectedIcon = Icons.Rounded.Subscriptions,
    unselectedIcon = Icons.Outlined.Subscriptions,
    title = R.string.tab_series,
  ),
  Search(
    tabDestination = TabDestination.SearchScreen,
    selectedIcon = Icons.Rounded.Search,
    unselectedIcon = Icons.Outlined.Search,
    title = R.string.tab_search,
  ),
  Settings(
    tabDestination = TabDestination.SettingsScreen,
    selectedIcon = Icons.Rounded.Settings,
    unselectedIcon = Icons.Outlined.Settings,
    title = R.string.tab_settings,
  ),
}
