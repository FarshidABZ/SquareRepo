package com.farshidabz.squarerepo.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.farshidabz.squarerepo.databinding.FragmentRepoDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepoDetailFragment : Fragment() {
    lateinit var binding: FragmentRepoDetailBinding
    private val viewModel by viewModels<RepoDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRepoDetailBinding.inflate(inflater, container, false)

        configureViewModel()
        configureViews()

        return binding.root
    }

    private fun configureViewModel() {
        val args: RepoDetailFragmentArgs by navArgs()
        viewModel.repository = args.repository
        viewModel.isBookmarked.value = viewModel.repository.isBookmarked
    }

    private fun configureViews() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.backImageView.setOnClickListener { findNavController().popBackStack() }

        binding.bookmarkImageView.setOnClickListener { viewModel.toggleBookmark() }
    }
}