package com.aulia.favorite

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.aulia.core.ui.MovieAdapter
import com.aulia.favorite.databinding.FragmentFavoriteBinding
import com.aulia.favorite.di.DaggerFavoriteModule
import com.aulia.favorite.di.ViewModelFactory
import com.aulia.movieapp.ui.detail.DetailMovieActivity
import com.aulia.movieapp.di.FavoriteModuleDependencies
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    private var _binding: FragmentFavoriteBinding? = null

    private val binding get() = _binding as FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFavoriteModule.builder()
            .context(context)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    context,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val movieAdapter = MovieAdapter()
            movieAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            favoriteViewModel.moviesFavorite.observe(viewLifecycleOwner) { movie ->

                if (movie.isNotEmpty()) {
                    binding.textEmpty.visibility = View.GONE
                    movieAdapter.setData(movie)

                } else {
                    binding.textEmpty.visibility = View.VISIBLE
                    movieAdapter.setData(movie)
                }

                with(binding.rvMovieFavorite) {
                    layoutManager = GridLayoutManager(activity, 2)
                    setHasFixedSize(true)
                    adapter = movieAdapter
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}