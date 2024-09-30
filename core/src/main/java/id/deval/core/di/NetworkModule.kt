package id.deval.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.deval.core.BuildConfig
import id.deval.core.data.source.remote.network.ApiService
import okhttp3.CertificatePinner
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideOkHttpClient() : OkHttpClient {
        val interceptor = Interceptor { chain ->
            val originalRequst = chain.request()
            val requestWithApiKey = originalRequst.url.newBuilder()
                .addQueryParameter("key", BuildConfig.API_KEY)
                .build()

            val newRequest = originalRequst.newBuilder()
                .url(requestWithApiKey)
                .build()
            chain.proceed(newRequest)
        }

        val certificatePinning = CertificatePinner.Builder()
            .add(HOST_NAME, "sha256/Ti5AhU6OcJWgTQfedHg7+xEaS6XE1iOgqkeZX161P7U=")
            .add(HOST_NAME, "sha256/b0kr6GUvjgiM8He9NBD+PpV3XaC8gCh9D+sTVN/HAbU=")
            .build()

        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(interceptor)
            .connectTimeout(120, TimeUnit.SECONDS )
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinning)
            .build()
    }

    @Provides
    fun provideApiService(client : OkHttpClient) : ApiService {

         val retrofit = Retrofit.Builder()
            .baseUrl("https://$HOST_NAME/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }

    companion object {
        const val HOST_NAME = "api.rawg.io"
    }

}