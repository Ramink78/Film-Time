package io.filmtime.tv.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import io.filmtime.tv.ui.detail.movie.navigateToMovieDetail
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
  onHideTabBar: () -> Unit,
  onShowTabBar: () -> Unit,
) {
  NavHost(
    navController = navController,
    startDestination = HomeGraph,
    modifier = modifier,
  ) {
    homeGraph(
      onFirstItemVisibleChange = { isVisible ->
        if (isVisible) {
          onShowTabBar()
        } else {
          onHideTabBar()
        }
      },
      onNavigateToMovieDetail = {
        onHideTabBar()
        navController.navigateToMovieDetail(it)
      },
    )
    moviesGraph()
    searchGraph()
    settingsGraph()
    showsGraph()
  }
}
