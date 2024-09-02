package io.filmtime.tv.ui.settings

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import io.filmtime.tv.ui.navigation.TabDestination.SettingsScreen
import kotlinx.serialization.Serializable

@Serializable
data object SettingsGraph

fun NavGraphBuilder.settingsGraph() {
  navigation<SettingsGraph>(
    startDestination = SettingsScreen,
  ) {
    composable<SettingsScreen>() {
      SettingsScreen(
        modifier = Modifier.fillMaxSize(),
      )
    }
  }
}
