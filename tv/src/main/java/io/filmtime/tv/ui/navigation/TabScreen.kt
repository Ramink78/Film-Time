package io.filmtime.tv.ui.navigation

import io.filmtime.core.ui.navigation.DestinationRoute
import io.filmtime.tv.ui.home.GRAPH_HOME_ROUTE

sealed class TabScreen(val destinationRoute: DestinationRoute) {
  data object Home : TabScreen(GRAPH_HOME_ROUTE)
  data object Shows : TabScreen(DestinationRoute(""))
  data object Movies : TabScreen(DestinationRoute(""))
  data object Search : TabScreen(DestinationRoute(""))
  data object Settings : TabScreen(DestinationRoute(""))
}
