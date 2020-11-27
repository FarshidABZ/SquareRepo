package com.farshidabz.squarerepo.view.repolist.databinding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.farshidabz.squarerepo.R
import com.farshidabz.squarerepo.domain.model.presentation.RepositoryUIModel
import com.farshidabz.squarerepo.util.extension.isNotNullOrEmpty
import com.farshidabz.squarerepo.view.repolist.adapter.RepositoryListAdapter


/**
 * DataBinding adapter extension to set recyclerview's adapter's list.
 *
 * set RepositoryAdapter items.
 *
 * @param recyclerView the RecyclerView to set list.
 * @param items the ListOf RepositoryUIModel is the repository list wants to show on UI.
 *
 * app:items should be load into XML layout file
 * */
@BindingAdapter("app:items")
fun RecyclerView.setItems(items: List<RepositoryUIModel>?) {
    (this.adapter as RepositoryListAdapter).submitList(items)
}

@BindingAdapter("app:startsCount")
fun TextView.setStartsCount(stars: Int) {
    this.text = if (stars < 1000) {
        this.context.getString(R.string.stars, stars)
    } else {
        this.context.getString(R.string.thousand_stars, stars / 1000)
    }
}

@BindingAdapter("app:bookmarkIcon")
fun ImageView.setBookmarkIcon(isBookmarked: Boolean) {
    this.setImageResource(if (isBookmarked) R.drawable.ic_bookmark else R.drawable.ic_bookmark_border)
}

@BindingAdapter("app:description")
fun TextView.setDescription(description: String?) {
    this.text = if (description.isNotNullOrEmpty()) {
        description
    } else {
        this.context.getString(R.string.no_description)
    }
}