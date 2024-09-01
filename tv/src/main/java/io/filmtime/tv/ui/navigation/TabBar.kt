package io.filmtime.tv.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.tv.material3.Icon
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Tab
import androidx.tv.material3.TabRow
import androidx.tv.material3.Text

@Composable
fun TabBar(
  tabs: List<TabDestination>,
  currentDestination: NavDestination?,
  onTabSelected: (TabScreen) -> Unit,
  modifier: Modifier = Modifier,
  selectedTabIndex: Int,
) {
  Box(modifier = modifier, contentAlignment = Alignment.Center) {
    TabRow(
      selectedTabIndex = selectedTabIndex,
    ) {
      tabs.forEach { tabDestination ->
        val selected = currentDestination?.route == tabDestination.name
        Tab(
          selected = selected,
          onFocus = { onTabSelected(tabDestination.tabScreen) },
        ) {
          Row(
            modifier = Modifier
              .height(32.dp)
              .padding(start = 12.dp, end = 16.dp, top = 6.dp, bottom = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
          ) {
            Icon(
              imageVector = if (selected) tabDestination.selectedIcon else tabDestination.unselectedIcon,
              contentDescription = "${tabDestination.title} icon",
              modifier = Modifier
                .padding(end = 6.dp)
                .size(18.dp),
            )
            Text(
              text = stringResource(tabDestination.title),
              style = MaterialTheme.typography.titleSmall,
            )
          }
        }
      }
    }
  }
}
