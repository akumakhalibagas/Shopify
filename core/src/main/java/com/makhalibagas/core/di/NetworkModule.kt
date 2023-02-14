package com.makhalibagas.core.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.makhalibagas.core.BuildConfig
import com.makhalibagas.core.data.source.remote.network.ShopifyApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        val chuckerCollector = ChuckerCollector(
            context = context,
            showNotification = BuildConfig.DEBUG,
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )

        val chuckInterceptor = ChuckerInterceptor.Builder(context)
            .collector(chuckerCollector)
            .maxContentLength(250000L)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(true)
            .build()

        httpLoggingInterceptor.setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
        return OkHttpClient.Builder()
            .writeTimeout(0, TimeUnit.MINUTES)
            .readTimeout(0, TimeUnit.MINUTES)
            .connectTimeout(0, TimeUnit.MINUTES)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(chuckInterceptor)
            .addInterceptor(getInterceptor())
            .build()
    }

    private fun getInterceptor() = Interceptor { chain: Interceptor.Chain ->
        val oldRequest = chain.request()
        val newRequestBuilder = oldRequest.newBuilder()
        val newRequest: Request = newRequestBuilder.build()
        chain.proceed(newRequest)
    }

    private fun retrofitBuilder(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


    @Provides
    fun provideShopifyApiService(client: OkHttpClient): ShopifyApiService =
        retrofitBuilder(client).create(ShopifyApiService::class.java)

}
