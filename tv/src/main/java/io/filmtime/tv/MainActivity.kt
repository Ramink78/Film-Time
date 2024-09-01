package io.filmtime.tv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.tv.material3.Surface
import io.filmtime.tv.ui.theme.FilmTimeTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      FilmTimeTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          shape = RectangleShape,
        ) {
          FilmTimeTvApp()
        }
      }
    }
  }
}
