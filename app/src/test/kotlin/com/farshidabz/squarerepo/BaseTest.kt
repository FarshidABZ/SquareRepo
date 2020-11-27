package com.farshidabz.squarerepo


import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.farshidabz.squarerepo.data.source.local.AppDatabase
import com.farshidabz.squarerepo.helpers.RequestDispatcher
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


internal open class BaseTest {
    protected lateinit var database: AppDatabase
    private lateinit var mockWebServer: MockWebServer

    lateinit var retrofit: Retrofit

    private lateinit var okHttpClient: OkHttpClient

    private lateinit var loggingInterceptor: HttpLoggingInterceptor

    @Before
    open fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = RequestDispatcher()
        mockWebServer.start()

        loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        okHttpClient = buildOkhttpClient(loggingInterceptor)

        retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

        database =
            Room.databaseBuilder(getApplicationContext(), AppDatabase::class.java, "repositories")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }

    fun <T> getApiService(apiServiceInterfaceClass: Class<T>): T {
        return retrofit.create(apiServiceInterfaceClass)
    }

    @After
    open fun tearDown() {
        mockWebServer.shutdown()
        database.close()
    }

    private fun buildOkhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }
}