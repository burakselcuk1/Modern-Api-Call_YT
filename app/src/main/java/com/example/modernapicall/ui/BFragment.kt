package com.example.modernapicall.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modernapicall.R
import com.example.modernapicall.Utils.Resource
import com.example.modernapicall.adapter.MovieAdapter
import com.example.modernapicall.databinding.FragmentABinding
import com.example.modernapicall.databinding.FragmentBBinding
import com.example.modernapicall.viewModels.MainPageViewModel


class BFragment : Fragment() {

    private var _binding: FragmentBBinding? = null
    private lateinit var adapter: MovieAdapter
    private val binding get() = _binding!!
    private lateinit var viewModel: MainPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        provideViewModel()
        getMovies()
    }

    private fun provideViewModel() {
        viewModel = ViewModelProvider(requireActivity()).get(MainPageViewModel::class.java)
    }
    private fun getMovies() {
        viewModel.movie.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success ->{
                    binding.progressBar.visibility = View.GONE
                    adapter = MovieAdapter(it.data)
                    binding.dataRecyclerview.layoutManager = LinearLayoutManager(context)
                    binding.dataRecyclerview.adapter = adapter
                }
                is Resource.Failure ->{
                    Toast.makeText(requireContext(), it.msg, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}