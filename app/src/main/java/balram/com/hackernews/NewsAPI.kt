package com.droidcba.kedditbysteps.api

import balram.com.hackernews.RedditNewsResponse
import retrofit2.Call


interface NewsAPI {
    fun getNews(after: String, limit: String): Call<RedditNewsResponse>
}