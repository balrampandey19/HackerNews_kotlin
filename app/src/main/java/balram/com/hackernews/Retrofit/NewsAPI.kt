package balram.com.hackernews.Retrofit


interface NewsAPI {
    fun getNews(after: String, limit: String): retrofit2.Call<RedditNewsResponse>
}