plugins {
  id("io.filmtime.gradle.application.tv")
  alias(libs.plugins.kotlinx.serialization)
}

android {
  namespace = "io.filmtime.tv"

  defaultConfig {
    applicationId = "io.filmtime.tv"
  }

  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {
  implementation(libs.core.ktx)
  implementation(libs.appcompat)
  implementation(libs.lifecycle.runtime.ktx)
  implementation(libs.activity.compose)
  implementation(project(":core:ui:common"))
  implementation(libs.icons.extended)
  implementation(project(":domain:tmdb-movies"))
  implementation(project(":domain:tmdb-shows"))
  implementation(project(":data:model"))
  implementation(project(":domain:trakt:trakt"))
  implementation(project(":domain:trakt:history"))
  implementation(libs.androidx.hilt.navigation.compose)
  implementation(libs.lifecycle.viewmodel.compose.runtime)
  implementation(libs.coil.compose)
  implementation(libs.kotlinx.serialization.json)
}
