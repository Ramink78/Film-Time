package io.filmtime.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.filmtime.data.network.adapter.NetworkCallAdapterFactory
import io.filmtime.data.network.interceptor.ApiKeyInterceptor
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

  @Provides
  @Singleton
  fun providesJson(): Json {
    return Json {
      ignoreUnknownKeys = true
    }
  }

  @Provides
  @Singleton
  fun providesInterceptor(): Map<Int, @JvmSuppressWildcards Interceptor> {
    return mapOf(
      1 to ApiKeyInterceptor()
    )
  }

  @Provides
  @Singleton
  fun providesOkHttpClient(interceptor: Map<Int, @JvmSuppressWildcards Interceptor>): OkHttpClient{
    val builder = OkHttpClient.Builder()
    if (interceptor.isNotEmpty()){
      for ((key,value) in interceptor){
        builder.addInterceptor(value)
      }
    }
    return builder.build()
  }

  @Provides
  @Singleton
  fun providesRetrofit(
    json: Json,
    networkCallAdapterFactory: CallAdapter.Factory,
    okHttpClient: OkHttpClient
  ): Retrofit {
    return Retrofit.Builder()
      .baseUrl("https://api.themoviedb.org/3/")
      .addConverterFactory(json.asConverterFactory(MediaType.get("application/json")))
      .addCallAdapterFactory(networkCallAdapterFactory)
      .client(okHttpClient)
      .build()
  }

  @Provides
  @Singleton
  fun providesTmdbMovieService(retrofit: Retrofit): TmdbMoviesService {
    return retrofit.create(TmdbMoviesService::class.java)
  }

  @Provides
  @Singleton
  fun providesTmdbShowsService(retrofit: Retrofit): TmdbShowsService {
    return retrofit.create(TmdbShowsService::class.java)
  }

  @Provides
  @Singleton
  fun providesNetworkCallAdapterFactory(): CallAdapter.Factory {
    return NetworkCallAdapterFactory()
  }
}
