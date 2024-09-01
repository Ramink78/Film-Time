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

enum class TabDestination(
  val tabScreen: TabScreen,
  val selectedIcon: ImageVector,
  val unselectedIcon: ImageVector,
  val title: Int,
) {
  Home(
    tabScreen = TabScreen.Home,
    selectedIcon = Icons.Rounded.Home,
    unselectedIcon = Icons.Outlined.Home,
    title = R.string.tab_home,
  ),
  Movies(
    tabScreen = TabScreen.Movies,
    selectedIcon = Icons.Rounded.Movie,
    unselectedIcon = Icons.Outlined.Movie,
    title = R.string.tab_movies,
  ),
  Shows(
    tabScreen = TabScreen.Shows,
    selectedIcon = Icons.Rounded.Subscriptions,
    unselectedIcon = Icons.Outlined.Subscriptions,
    title = R.string.tab_series,
  ),
  Search(
    tabScreen = TabScreen.Search,
    selectedIcon = Icons.Rounded.Search,
    unselectedIcon = Icons.Outlined.Search,
    title = R.string.tab_search,
  ),
  Settings(
    tabScreen = TabScreen.Settings,
    selectedIcon = Icons.Rounded.Settings,
    unselectedIcon = Icons.Outlined.Settings,
    title = R.string.tab_settings,
  ),
}
