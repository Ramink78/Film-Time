package io.filmtime.tv.ui.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import io.filmtime.core.ui.navigation.DestinationRoute
import io.filmtime.core.ui.navigation.composable
import io.filmtime.tv.ui.navigation.TabDestination

val GRAPH_HOME_ROUTE = DestinationRoute("home_graph_route")

fun NavGraphBuilder.homeGraph(
  onMovieClick: (rootRoute: DestinationRoute, tmdbId: Int) -> Unit,
  onShowClick: (rootRoute: DestinationRoute, tmdbId: Int) -> Unit,
  onTrendingMoviesClick: (rootRoute: DestinationRoute) -> Unit,
  onTrendingShowsClick: (rootRoute: DestinationRoute) -> Unit,
  nestedGraphs: NavGraphBuilder.(DestinationRoute) -> Unit,
) {
  navigation(
    route = GRAPH_HOME_ROUTE.route,
    startDestination = TabDestination.Home.name,
  ) {
    composable(
      route = TabDestination.Home.name,
      screenName = "Home",
    ) {
      HomeScreen(
        onMovieClick = { onMovieClick(GRAPH_HOME_ROUTE, it) },
        onShowClick = { onShowClick(GRAPH_HOME_ROUTE, it) },
        onTrendingMoviesClick = { onTrendingMoviesClick(GRAPH_HOME_ROUTE) },
        onTrendingShowsClick = { onTrendingShowsClick(GRAPH_HOME_ROUTE) },
      )
    }

    nestedGraphs(GRAPH_HOME_ROUTE)
  }
}
