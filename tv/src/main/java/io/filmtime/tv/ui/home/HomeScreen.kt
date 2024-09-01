package io.filmtime.tv.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
  onMovieClick: (tmdbId: Int) -> Unit,
  onShowClick: (tmdbId: Int) -> Unit,
  onTrendingMoviesClick: () -> Unit,
  onTrendingShowsClick: () -> Unit,
) {
  Box(
    modifier = Modifier
      .fillMaxSize(),
  ) {
  }
}
