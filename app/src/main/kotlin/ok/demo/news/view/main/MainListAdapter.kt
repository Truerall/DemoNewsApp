package ok.demo.news.view.main

import android.content.Context
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_article.view.*
import ok.demo.news.model.data_models.Article


class MainListAdapter(private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    private val formatter = DateFormat.getDateFormat(context)
    private var dataSet: MutableList<Article> = mutableListOf()
    lateinit var onItemClick: (Article) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(ok.demo.news.R.layout.item_article, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position], onItemClick, formatter)
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun setData(newDataSet: List<Article>) {
        this.dataSet.addAll(newDataSet)
        notifyDataSetChanged()
    }
}

class ViewHolder(val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

    private lateinit var onItemClick: (Article) -> Unit
    private lateinit var item: Article

    fun bind(
        item: Article,
        clickListener: (Article) -> Unit,
        formatter: java.text.DateFormat
    ) {
        this.onItemClick = clickListener
        this.item = item

        view.item_article_tv_title.text = item.title
        view.item_article_tv_description.text = item.description
        Glide.with(view.context)
            .load(item.urlToImage)
            .placeholder(ok.demo.news.R.drawable.ic_news_place_holder)
            .into(view.item_article_iv_image)
        view.item_article_tv_date.text = formatter.format(item.publishedAt)
        view.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        onItemClick.invoke(this.item)
    }
}