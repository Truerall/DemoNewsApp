package ok.demo.news.view.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_detail.view.*
import ok.demo.news.R

class DetailsListAdapter(private val context: Context) : RecyclerView.Adapter<DetailsViewHolder>() {

    private var dataSet: List<DetailsViewModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        return DetailsViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_detail,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun setData(newDataSet: List<DetailsViewModel>) {
        dataSet = newDataSet
        notifyDataSetChanged()
    }
}

class DetailsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: DetailsViewModel) {
        view.item_article_tv_header.text = item.header
        view.item_article_tv_content.text = item.content
    }
}