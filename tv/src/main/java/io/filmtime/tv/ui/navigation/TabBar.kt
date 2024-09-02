package io.filmtime.tv.ui.navigation

import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Icon
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Tab
import androidx.tv.material3.TabRow
import androidx.tv.material3.Text

@Composable
fun TabBar(
  tabs: List<TabItem>,
  onTabSelected: (TabDestination) -> Unit,
  modifier: Modifier = Modifier,
  selectedTabItem: TabItem,
) {
  var focusedTabIndex by remember {
    mutableIntStateOf(0)
  }
  Box(modifier = modifier, contentAlignment = Alignment.Center) {
    TabRow(
      selectedTabIndex = TabItem.entries.indexOf(selectedTabItem),
      modifier = Modifier.focusGroup(),
    ) {
      tabs.forEachIndexed { index, tabDestination ->
        val selected = tabDestination == TabItem.valueOf(selectedTabItem.name)
        Tab(
          selected = selected,
          onFocus = {
            onTabSelected(tabDestination.tabDestination)
            focusedTabIndex = index
          },
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
