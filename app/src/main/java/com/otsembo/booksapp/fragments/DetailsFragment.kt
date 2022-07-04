package com.otsembo.booksapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.otsembo.booksapp.adapters.BooksAdapter
import com.otsembo.booksapp.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val date = arguments?.getString(BooksAdapter.BookHolder.DATE, "0-0-0")
        val desc = arguments?.getString(BooksAdapter.BookHolder.DESC, "NO DESC FOUND")
        binding.txtBookDesc.text = desc
        binding.txtBookYear.text = date
        return binding.root
    }
}
