package com.example.modernapicall.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.modernapicall.R
import com.example.modernapicall.databinding.FragmentABinding


class AFragment : Fragment() {
    private var _binding : FragmentABinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentABinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.getMyDatas.setOnClickListener {
            val navigationController = Navigation.findNavController(it)
            navigationController.navigate(R.id.action_AFragment_to_BFragment)
        }

    }
}