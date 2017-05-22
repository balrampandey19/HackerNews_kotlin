package balram.com.hackernews.Retrofit

class NewsRestAPI @javax.inject.Inject constructor(private val redditApi: com.droidcba.kedditbysteps.api.RedditApi) : com.droidcba.kedditbysteps.api.NewsAPI {

    override fun getNews(after: String, limit: String): retrofit2.Call<RedditNewsResponse> {
        return redditApi.getTop(after, limit)
    }
}