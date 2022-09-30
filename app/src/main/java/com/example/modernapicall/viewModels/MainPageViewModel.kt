package com.example.modernapicall.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modernapicall.Utils.Resource
import com.example.modernapicall.repository.MovieRepository
import com.example.shortmovieapp.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(private val repository: MovieRepository):ViewModel() {

  private  val _movie = MutableLiveData<Resource>()
  val movie : LiveData<Resource> = _movie

    init {
        getMovies()
    }


    fun getMovies()=viewModelScope.launch {
        _movie.value = Resource.Loading

        repository.getMovies().runCatching {
            _movie.value = Resource.Success(this)
        }
    }
}