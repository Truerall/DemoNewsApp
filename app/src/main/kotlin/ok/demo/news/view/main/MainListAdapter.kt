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

    private var dataSet: MutableList<Article> = mutableListOf()
    private val formatter = DateFormat.getDateFormat(context)
    lateinit var onItemClick: () -> Unit

    private val onClickListener = View.OnClickListener {
        onItemClick.invoke()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(ok.demo.news.R.layout.item_article, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = dataSet[position].title
        holder.tvDescription.text = dataSet[position].description
        Glide.with(holder.itemView.context)
            .load(dataSet[position].urlToImage)
            .placeholder(ok.demo.news.R.drawable.ic_news_place_holder)
            .into(holder.ivImage)
        holder.tvDate.text = formatter.format(dataSet[position].publishedAt)
        holder.itemView.setOnClickListener(onClickListener)
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

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivImage = view.item_article_iv_image
    val tvTitle = view.item_article_tv_title
    val tvDescription = view.item_article_tv_description
    val tvDate = view.item_article_tv_date
}