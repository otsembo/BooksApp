package com.otsembo.booksapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.otsembo.booksapp.adapters.Book
import com.otsembo.booksapp.adapters.BooksAdapter
import com.otsembo.booksapp.databinding.FragmentBookListBinding

class BookListFragment : Fragment() {

    private lateinit var binding: FragmentBookListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookListBinding.inflate(inflater, container, false)
        val adapter = BooksAdapter(getBooks())
        binding.bookList.adapter = adapter
        return binding.root
    }

    companion object {
        fun getBooks(): List<Book> {
            val bookList = ArrayList<Book>()
            bookList.add(
                Book("https://images-na.ssl-images-amazon.com/images/I/41VH33HEACL.jpg", "The 48 laws of power", "1998", "Robert Greene")
            )
            bookList.add(
                Book("https://images-na.ssl-images-amazon.com/images/I/71KV-xnQu0L.jpg", "The Art of seduction", "2001", "Robert Greene")
            )
            bookList.add(
                Book("https://images-na.ssl-images-amazon.com/images/I/71LRdEUOmNL.jpg", "Mastery", "2012", "Robert Greene")
            )
            bookList.add(
                Book("https://cdnattic.atticbooks.co.ke/img/964609.png", "Laws of human nature", "2018", "Robert Greene")
            )
            return bookList
        }
    }
}
