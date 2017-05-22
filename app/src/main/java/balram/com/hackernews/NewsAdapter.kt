package balram.com.hackernews

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

import balram.com.hackernews.Retrofit.RedditNewsResponse

/**
 * Created by Balram Pandey
 */

class NewsAdapter(internal var context: Context, internal var rowItems: List<RedditNewsResponse>) : BaseAdapter() {

    private inner class ViewHolder {
        internal var imageView: ImageView? = null
        internal var txtTitle: TextView? = null
        internal var txtDesc: TextView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        var holder: ViewHolder? = null

        val mInflater = context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null)
            holder = ViewHolder()
            holder.txtDesc = convertView!!.findViewById(R.id.desc) as TextView
            holder.txtTitle = convertView.findViewById(R.id.title) as TextView
            holder.imageView = convertView.findViewById(R.id.icon) as ImageView
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }

        val rowItem = getItem(position) as RowItem
        holder.txtDesc!!.setText(rowItem.getDesc())
        holder.txtTitle!!.setText(rowItem.getTitle())
        holder.imageView!!.setImageResource(rowItem.getImageId())

        return convertView
    }

    override fun getCount(): Int {
        return rowItems.size
    }

    override fun getItem(position: Int): Any {
        return rowItems[position]
    }

    override fun getItemId(position: Int): Long {
        return rowItems.indexOf(getItem(position)).toLong()
    }
}