package com.farshidabz.squarerepo.view.repolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.farshidabz.squarerepo.databinding.FragmentRepositoryListBinding
import com.farshidabz.squarerepo.view.repolist.adapter.RepositoryListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepositoryListFragment : Fragment() {
    private lateinit var binding: FragmentRepositoryListBinding
    private val viewModel by viewModels<RepositoryListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRepositoryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureView()
        configureViewModel()

        viewModel.observeDb()
    }

    private fun configureView() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.adapter = RepositoryListAdapter()

        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.refreshList()
        }
    }

    private fun configureViewModel() {
        viewModel.errorModel.observe(viewLifecycleOwner) {
            // TODO: 11/23/20 show error message here
        }
    }
}