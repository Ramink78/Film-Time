package io.filmtime.tv.ui.series

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import io.filmtime.tv.ui.navigation.TabDestination.ShowsScreen
import kotlinx.serialization.Serializable

@Serializable
data object ShowsGraph

fun NavGraphBuilder.showsGraph() {
  navigation<ShowsGraph>(
    startDestination = ShowsScreen,
  ) {
    composable<ShowsScreen>() {
      SeriesScreen(
        modifier = Modifier.fillMaxSize(),
      )
    }
  }
}
