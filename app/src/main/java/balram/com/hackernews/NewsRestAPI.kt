package com.droidcba.kedditbysteps.api

import balram.com.hackernews.RedditNewsResponse
import retrofit2.Call

class NewsRestAPI @javax.inject.Inject constructor(private val redditApi: RedditApi) : NewsAPI {

    override fun getNews(after: String, limit: String): Call<RedditNewsResponse> {
        return redditApi.getTop(after, limit)
    }
}