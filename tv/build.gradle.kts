plugins {
  id("io.filmtime.gradle.android.application")
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
  implementation(platform(libs.compose.bom))
  implementation(libs.ui.tooling.preview)
  implementation(libs.androidx.tv.foundation)
  implementation(libs.androidx.tv.material)
  implementation(libs.lifecycle.runtime.ktx)
  implementation(libs.activity.compose)
  androidTestImplementation(platform(libs.compose.bom))
  androidTestImplementation(libs.ui.test.junit4)
  debugImplementation(libs.ui.tooling)
  debugImplementation(libs.ui.test.manifest)
}
