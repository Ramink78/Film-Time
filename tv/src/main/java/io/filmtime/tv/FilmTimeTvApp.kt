package io.filmtime.tv

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import io.filmtime.tv.ui.home.HomeGraph
import io.filmtime.tv.ui.movies.MoviesGraph
import io.filmtime.tv.ui.navigation.TabBar
import io.filmtime.tv.ui.navigation.TabDestination.HomeScreen
import io.filmtime.tv.ui.navigation.TabDestination.MoviesScreen
import io.filmtime.tv.ui.navigation.TabDestination.SearchScreen
import io.filmtime.tv.ui.navigation.TabDestination.SettingsScreen
import io.filmtime.tv.ui.navigation.TabDestination.ShowsScreen
import io.filmtime.tv.ui.navigation.TabItem
import io.filmtime.tv.ui.navigation.TvNavHost
import io.filmtime.tv.ui.navigation.tabDestination
import io.filmtime.tv.ui.navigation.toTabItem
import io.filmtime.tv.ui.search.SearchGraph
import io.filmtime.tv.ui.series.ShowsGraph
import io.filmtime.tv.ui.settings.SettingsGraph

@Composable
fun FilmTimeTvApp() {
  val navController = rememberNavController()
  val currentBackStackEntry by navController.currentBackStackEntryAsState()
  val currentTab: TabItem = currentBackStackEntry.tabDestination().toTabItem()
  var topBarHeightPx: Int by rememberSaveable { mutableIntStateOf(0) }
  var isTopBarVisible by remember {
    mutableStateOf(true)
  }
  val topBarYOffset by animateIntAsState(
    targetValue = if (isTopBarVisible) {
      0
    } else {
      -topBarHeightPx
    },
    label = "TopBar Offset Animation",
  )
  val navHostYOffset by animateIntAsState(
    targetValue = if (isTopBarVisible) {
      topBarHeightPx
    } else {
      0
    },
    label = "NavHost Offset Animation",
  )
  TabBar(
    tabs = TabItem.entries,
    selectedTabItem = currentTab,
    onTabSelected = {
      val navOption = navOptions {
        popUpTo(navController.graph.findStartDestination().id) {
          saveState = true
        }
        launchSingleTop = true
        restoreState = true
      }
      when (it) {
        HomeScreen -> navController.navigate(HomeGraph, navOption)
        MoviesScreen -> navController.navigate(MoviesGraph, navOption)
        SearchScreen -> navController.navigate(SearchGraph, navOption)
        SettingsScreen -> navController.navigate(SettingsGraph, navOption)
        ShowsScreen -> navController.navigate(ShowsGraph, navOption)
      }
    },
    modifier = Modifier
      .offset {
        IntOffset(0, topBarYOffset)
      }
      .fillMaxWidth()
      .onSizeChanged {
        topBarHeightPx = it.height
      }
      .padding(vertical = 16.dp),
  )
  TvNavHost(
    navController = navController,
    modifier = Modifier.offset {
      IntOffset(0, navHostYOffset)
    },
    onTopBarVisibleChange = { isVisible ->
      isTopBarVisible = isVisible
    },
  )
}
