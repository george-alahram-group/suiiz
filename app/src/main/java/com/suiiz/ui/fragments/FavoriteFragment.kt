package com.suiiz.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.suiiz.R
import com.suiiz.adapters.favorite_fragment_adapters.FavoriteAdapter
import com.suiiz.databinding.FragmentFavoriteBinding
import com.suiiz.util.DummyData


class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private var _binding : FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFavoriteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    lateinit var favoriteAdapter: FavoriteAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()

    }
    private fun setListener() {
        favoriteAdapter = FavoriteAdapter(requireContext())
        favoriteAdapter.differ.submitList(DummyData.favoriteList(resources))
        binding.rvFavorite.adapter = favoriteAdapter
    }

}