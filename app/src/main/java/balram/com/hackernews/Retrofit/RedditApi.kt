package balram.com.hackernews.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Balram Pandey
 */
interface  RedditApi {
    @GET("/top.json")
    fun getTop(@Query("limit") limit: String): Call<RedditNewsResponse>;
}