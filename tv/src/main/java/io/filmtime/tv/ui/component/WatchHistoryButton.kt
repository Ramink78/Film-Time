package io.filmtime.tv.ui.component

import androidx.compose.animation.AnimatedContent
import androidx.compose.material.icons.Icons.AutoMirrored
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.automirrored.rounded.PlaylistAdd
import androidx.compose.material.icons.rounded.PlaylistRemove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.tv.material3.Button
import androidx.tv.material3.Icon
import androidx.tv.material3.Text
import androidx.tv.material3.WideButtonDefaults
import io.filmtime.data.model.VideoType
import io.filmtime.tv.R
import io.filmtime.tv.ui.traktbutton.TraktMovieHistoryViewModel

@Composable
fun WatchHistoryButton(
  modifier: Modifier = Modifier,
  tmdbId: Int,
  videoType: VideoType,
) {
  val viewModel: TraktMovieHistoryViewModel = hiltViewModel()
  val uiState by viewModel.state.collectAsStateWithLifecycle()
  LaunchedEffect(videoType, tmdbId) {
    viewModel.checkIfIsWatched(videoType, tmdbId)
  }
  Button(
    shape = WideButtonDefaults.shape(),
    modifier = modifier,
    enabled = !uiState.isError,
    onClick = {
      if (uiState.isWatched) {
        viewModel.removeItemFromHistory()
      } else {
        viewModel.addItemToHistory()
      }
    },
    content = {
      if (uiState.isLoading) {
        Text(text = stringResource(R.string.loading))
      } else {
        AnimatedContent(
          targetState = uiState.isWatched,
          label = "",
        ) { isWatchedState ->
          if (isWatchedState) {
            Icon(imageVector = Rounded.PlaylistRemove, contentDescription = "")
          } else {
            Icon(imageVector = AutoMirrored.Rounded.PlaylistAdd, contentDescription = "")
          }
        }
        Text(
          text = if (uiState.isWatched) {
            stringResource(R.string.mark_as_unwatched)
          } else {
            stringResource(R.string.mark_as_watched)
          },
        )
      }
    },
  )
}
