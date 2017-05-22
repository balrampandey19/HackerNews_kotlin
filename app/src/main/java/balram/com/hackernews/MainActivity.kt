package balram.com.hackernews

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import balram.com.hackernews.Retrofit.RedditApi
import balram.com.hackernews.Retrofit.RedditDataResponse
import balram.com.hackernews.Retrofit.RedditNewsResponse
import balram.com.hackernews.Retrofit.RetrofitServiceGSON
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listView= findViewById(R.id.news_list) as ListView
    }

    fun getRedditNews() {
        val userService = RetrofitServiceGSON.createService(RedditApi::class.java)
        val call = userService.getTop("50")
        call.enqueue(object : Callback<RedditNewsResponse> {
            override fun onResponse(call: Call<RedditNewsResponse>, response: Response<RedditNewsResponse>) {
                if (!response.isSuccessful()) {
                    Log.e("Error", response.errorBody().toString())
                } else {

                }
            }

            override fun onFailure(call: Call<RedditNewsResponse>, t: Throwable) {

            }
        })
    }
}
