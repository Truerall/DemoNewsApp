package nl.tmg.dutchnews.view.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_article.view.*
import nl.tmg.dutchnews.R
import nl.tmg.dutchnews.model.data_models.Article

class MainListAdapter(private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    private var dataSet: List<Article> = listOf()
    //TODO date per item //private val formatter = DateFormat.getDateFormat(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_article, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = dataSet[position].title
        holder.tvDescription.text = dataSet[position].description
        Glide.with(holder.itemView.context)
            .load(dataSet[position].urlToImage)
            .placeholder(R.drawable.ic_tmg_place_holder)
            .into(holder.ivImage)
        //formatter.format(dataSet[position].publishedAt)
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun setData(newDataSet: List<Article>){
        this.dataSet = newDataSet
        notifyDataSetChanged()
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivImage = view.item_article_iv_image
    val tvTitle = view.item_article_tv_title
    val tvDescription = view.item_article_tv_description
}