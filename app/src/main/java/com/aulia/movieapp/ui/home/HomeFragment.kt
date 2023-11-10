package com.aulia.movieapp.ui.home

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aulia.core.data.Resource
import com.aulia.core.ui.MovieAdapter
import com.aulia.movieapp.R
import com.aulia.movieapp.databinding.FragmentHomeBinding
import com.aulia.movieapp.ui.detail.DetailMovieActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var searchView: SearchView
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            movieAdapter = MovieAdapter()
            movieAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.movie.observe(viewLifecycleOwner) { movie ->
                if (movie != null) {
                    when (movie) {
                        is com.aulia.core.data.Resource.Loading -> binding.progressBar.visibility =
                            View.VISIBLE

                        is com.aulia.core.data.Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            movieAdapter.setData(movie.data)
                        }

                        is com.aulia.core.data.Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text =
                                movie.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            }

            with(binding.rvMovie) {
                layoutManager = GridLayoutManager(activity, 2)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }


        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.option_menu, menu)
                val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
                searchView = menu.findItem(R.id.search_menu).actionView as SearchView
                searchView.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
                searchView.queryHint = resources.getString(R.string.menu_search)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.search_menu -> {
                        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                            override fun onQueryTextSubmit(newText: String): Boolean {
                                return true
                            }

                            override fun onQueryTextChange(newText: String): Boolean {

                                newText.let {
                                    if (newText == "" || newText.isEmpty()) {

                                    } else {

                                    }
                                }
                                return true
                            }
                        })
                        true
                    }
                    R.id.setting_menu -> {
                        // todo menu2
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}