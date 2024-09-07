package io.filmtime.tv.ui.traktbutton

data class TraktAddRemoveUiState(
  val isLoading: Boolean = true,
  val isWatched: Boolean = false,
  val isError: Boolean = false,
  val traktId: Int? = null,
)
