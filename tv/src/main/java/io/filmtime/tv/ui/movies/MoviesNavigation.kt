package io.filmtime.tv.ui.movies

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import io.filmtime.tv.ui.navigation.TabDestination.MoviesScreen
import kotlinx.serialization.Serializable

@Serializable
data object MoviesGraph

fun NavGraphBuilder.moviesGraph() {
  navigation<MoviesGraph>(
    startDestination = MoviesScreen,
  ) {
    composable<MoviesScreen>() {
      MoviesScreen(
        modifier = Modifier.fillMaxSize(),
      )
    }
  }
}
