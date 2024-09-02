package io.filmtime.tv.ui.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import io.filmtime.tv.ui.navigation.TabDestination.SearchScreen
import kotlinx.serialization.Serializable

@Serializable
data object SearchGraph

fun NavGraphBuilder.searchGraph() {
  navigation<SearchGraph>(
    startDestination = SearchScreen,
  ) {
    composable<SearchScreen> {
      SearchScreen(
        modifier = Modifier.fillMaxSize(),
      )
    }
  }
}
