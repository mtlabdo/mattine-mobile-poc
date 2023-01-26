package com.mattine.mattinepoc.ui.articleList.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mattine.mattinepoc.ui.articleList.model.ArticleUiModel
import com.mattine.poc.ui.R

class ArticleListAdapter : Adapter<ArticleListAdapter.ArticleViewHolder>() {
    var onArticleClickListener: OnClickListener = OnClickListener.DoNothing

    private val delegateOnClickListener = DelegateOnClickListener()

    private val articles: MutableList<ArticleUiModel> = mutableListOf();

    fun setArticles(articles: List<ArticleUiModel>) {
        if (articles != this.articles) {
            if (this.articles.isNotEmpty()) {
                val lastItemCount = this.articles.size
                this.articles.clear()
                notifyItemRangeRemoved(0, lastItemCount)
            }
            this.articles.addAll(articles)
            notifyItemRangeInserted(0, articles.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
            .let { view ->
                ArticleViewHolder(delegateOnClickListener, view)
            }

    override fun getItemCount(): Int {
        return this.articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(this.articles[position])
    }

    class ArticleViewHolder(
        private val onClickListener: OnClickListener,
        itemView: View
    ) : ViewHolder(itemView) {
        private val imageView: TextView by lazy { itemView.findViewById(R.id.article_image) }
        private val nameField: TextView by lazy { itemView.findViewById(R.id.article_name) }
        fun bind(article: ArticleUiModel) {
            itemView.setOnClickListener {
                onClickListener.onArticleClick(articleId = article.matricule)
            }
            nameField.text = article.name
        }
    }

    inner class DelegateOnClickListener : OnClickListener {
        override fun onArticleClick(articleId: String) {
            onArticleClickListener.onArticleClick(articleId)
        }
    }

    interface OnClickListener {
        fun onArticleClick(articleId: String)

        object DoNothing : OnClickListener {
            override fun onArticleClick(articleId: String) = Unit
        }
    }
}