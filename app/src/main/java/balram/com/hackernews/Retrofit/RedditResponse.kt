package balram.com.hackernews.Retrofit

/**
 * Created by Balram Pandey
 */
class RedditNewsResponse(val data: balram.com.hackernews.Retrofit.RedditDataResponse)

class RedditDataResponse(
        val children: List<balram.com.hackernews.Retrofit.RedditChildrenResponse>,
        val after: String?,
        val before: String?
)

class RedditChildrenResponse(val data: balram.com.hackernews.Retrofit.RedditNewsDataResponse)

class RedditNewsDataResponse(
        val author: String,
        val title: String,
        val num_comments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String?
)