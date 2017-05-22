package balram.com.hackernews.Retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Balram Pandey
 */
object RetrofitServiceGSON {

    val API_BASE_URL = "https://www.googleapis.com/youtube/v3/"
    private val logging = HttpLoggingInterceptor()

    private val httpClient = OkHttpClient.Builder();

    private val builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S {

        httpClient.addInterceptor { chain ->
            var request = chain.request()
                request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build()
            chain.proceed(request)
        }

        val client = httpClient.build()
        logging.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(logging)
        val retrofit = builder.client(client).build()
        return retrofit.create(serviceClass)
    }
}