package com.aulia.movieapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.aulia.core.domain.model.Movie
import com.aulia.core.utils.Utils.toDateFormatYear
import com.aulia.movieapp.R
import com.aulia.movieapp.databinding.ActivityDetailMovieBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding

    private val detailMovieViewModel: DetailMovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetailMovie(detailMovie)
    }

    private fun showDetailMovie(detailMovie: Movie?) {
        detailMovie?.let {
            supportActionBar?.title = detailMovie.title
            binding.content.apply {
                tvTitle.text = detailMovie.title
                tvOverview.text = detailMovie.overview
                tvReleaseDate.text = detailMovie.releaseDate?.toDateFormatYear()
                tvOriginalLanguage.text = detailMovie.originalLanguage
                tvVoteAverage.text = detailMovie.voteAverage.toString()
                Glide.with(this@DetailMovieActivity)
                    .load("https://image.tmdb.org/t/p/w500${detailMovie.backdropPath}")
                    .into(ivBackdrop)

                Glide.with(this@DetailMovieActivity)
                    .load("https://image.tmdb.org/t/p/w500${detailMovie.posterPath}")
                    .into(ivPoster)

                var statusFavorite = detailMovie.isFavorite
                setStatusFavorite(statusFavorite)
                fab.setOnClickListener {
                    statusFavorite = !statusFavorite
                    detailMovieViewModel.setFavoriteMovie(detailMovie, statusFavorite)
                    setStatusFavorite(statusFavorite)
                }
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.content.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.content.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}