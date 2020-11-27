package com.farshidabz.squarerepo.view.repolist.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.farshidabz.squarerepo.domain.model.presentation.RepositoryUIModel

class RepositoryListAdapter :
    ListAdapter<RepositoryUIModel, RepositoryViewHolder>(REPOSITORY_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RepositoryViewHolder.create(parent)

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val REPOSITORY_COMPARATOR = object : DiffUtil.ItemCallback<RepositoryUIModel>() {
            override fun areItemsTheSame(
                oldItem: RepositoryUIModel,
                newItem: RepositoryUIModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: RepositoryUIModel,
                newItem: RepositoryUIModel
            ): Boolean {
                return oldItem.id == newItem.id && oldItem.isBookmarked == newItem.isBookmarked
            }
        }
    }
}