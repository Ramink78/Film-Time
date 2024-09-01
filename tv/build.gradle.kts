plugins {
  id("io.filmtime.gradle.application.tv")
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
  implementation(libs.androidx.navigation.compose)
  implementation(project(":core:ui:navigation"))
  implementation(libs.icons.extended)
}
