plugins {
  id("io.filmtime.gradle.android.library")
  id("io.filmtime.gradle.android.library.compose")
}

android {
  namespace = "io.filmtime.core.ui.common"
}

dependencies {
  implementation(project(":data:model"))
  implementation(project(":core:design-system"))

  implementation(libs.lottie)
  implementation(libs.paging.compose)
}
