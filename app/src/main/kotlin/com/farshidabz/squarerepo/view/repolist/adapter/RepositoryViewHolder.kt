package com.farshidabz.squarerepo.view.repolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.farshidabz.squarerepo.databinding.ItemRepositoryBinding
import com.farshidabz.squarerepo.domain.model.presentation.RepositoryUIModel
import com.farshidabz.squarerepo.view.repolist.RepositoryListFragmentDirections

class RepositoryViewHolder(private val binding: ItemRepositoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: RepositoryUIModel) {
        binding.item = item
        binding.setClickListener { onRepositoryClicked(it, item) }
    }

    private fun onRepositoryClicked(it: View?, item: RepositoryUIModel) {
        it?.findNavController()?.navigate(
            RepositoryListFragmentDirections.actionRepositoryListFragmentToRepoDetailFragment(item)
        )
    }

    companion object {
        fun create(parent: ViewGroup) = RepositoryViewHolder(
            ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
}