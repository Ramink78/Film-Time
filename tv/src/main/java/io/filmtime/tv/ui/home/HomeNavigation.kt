package io.filmtime.tv.ui.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import io.filmtime.tv.ui.navigation.TabDestination.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeGraph

fun NavGraphBuilder.homeGraph(
  onTopBarVisibleChange: (Boolean) -> Unit,
) {
  navigation<HomeGraph>(
    startDestination = HomeScreen,
  ) {
    composable<HomeScreen> {
      HomeScreen(
        onTopBarVisibleChange = onTopBarVisibleChange,
        onMovieClick = { },
        onShowClick = { },
        onTrendingMoviesClick = { },
        onTrendingShowsClick = {},
      )
    }
  }
}
