package io.filmtime.tv.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import io.filmtime.tv.ui.home.HomeGraph
import io.filmtime.tv.ui.home.homeGraph
import io.filmtime.tv.ui.movies.moviesGraph
import io.filmtime.tv.ui.search.searchGraph
import io.filmtime.tv.ui.series.showsGraph
import io.filmtime.tv.ui.settings.settingsGraph

@Composable
fun TvNavHost(
  modifier: Modifier = Modifier,
  navController: NavHostController,
  onTopBarVisibleChange: (Boolean) -> Unit,
) {
  NavHost(
    navController = navController,
    startDestination = HomeGraph,
    modifier = modifier,
  ) {
    homeGraph(
      onTopBarVisibleChange = onTopBarVisibleChange,
    )
    moviesGraph()
    searchGraph()
    settingsGraph()
    showsGraph()
  }
}
