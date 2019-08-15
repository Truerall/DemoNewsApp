package ok.demo.news.view.main.adapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION

class PaginationScrollListener(
    private val layoutManager: LinearLayoutManager,
    private val loadMoreLambda: () -> Unit
) : RecyclerView.OnScrollListener() {
    var isLoading = false

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (dy < 0) return

        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        if (!isLoading) {
            if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition != NO_POSITION) {
                isLoading = true
                loadMoreLambda.invoke()
            }
        }
    }
}