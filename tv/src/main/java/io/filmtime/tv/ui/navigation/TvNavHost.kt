package io.filmtime.tv.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import io.filmtime.core.ui.navigation.DestinationRoute
import io.filmtime.tv.ui.home.GRAPH_HOME_ROUTE
import io.filmtime.tv.ui.home.homeGraph

@Composable
fun TvNavHost(
  modifier: Modifier = Modifier,
  navController: NavHostController,
) {
  NavHost(
    navController = navController,
    startDestination = GRAPH_HOME_ROUTE.route,
    modifier = modifier,
  ) {
    homeGraph(
      onMovieClick = { rootRoute: DestinationRoute, tmdbId: Int -> },
      onShowClick = { rootRoute: DestinationRoute, tmdbId: Int -> },
      onTrendingMoviesClick = {},
      onTrendingShowsClick = {},
      nestedGraphs = {},
    )
  }
}
