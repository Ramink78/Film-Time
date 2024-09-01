package io.filmtime.tv

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.filmtime.tv.ui.navigation.TabBar
import io.filmtime.tv.ui.navigation.TabDestination
import io.filmtime.tv.ui.navigation.TvNavHost

@Composable
fun FilmTimeTvApp() {
  val navController = rememberNavController()
  val currentBackStackEntry by navController.currentBackStackEntryAsState()
  val currentDestination = currentBackStackEntry?.destination
  val selectedTabIndex = currentDestination?.route?.let {
    TabDestination.entries.indexOf(TabDestination.valueOf(it))
  } ?: 0
  var topBarHeightPx: Int by rememberSaveable { mutableIntStateOf(0) }
  TabBar(
    tabs = TabDestination.entries,
    currentDestination = currentDestination,
    onTabSelected = {},
    selectedTabIndex = selectedTabIndex,
    modifier = Modifier
      .fillMaxWidth()
      .onSizeChanged {
        topBarHeightPx = it.height
      }
      .padding(vertical = 16.dp),
  )
  TvNavHost(
    navController = navController,
    modifier = Modifier.offset {
      IntOffset(0, topBarHeightPx.toDp().roundToPx())
    },
  )
}
