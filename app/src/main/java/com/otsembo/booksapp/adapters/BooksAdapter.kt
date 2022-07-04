package com.otsembo.booksapp.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.otsembo.booksapp.R
import com.otsembo.booksapp.databinding.FragmentBookItemBinding

class BooksAdapter(private val bookItems: List<Book>) : RecyclerView.Adapter<BooksAdapter.BookHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: FragmentBookItemBinding = FragmentBookItemBinding.inflate(inflater, parent, false)
        val holder = BookHolder(binding)
        return holder
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        val book = bookItems[position]
        holder.bindData(book)
    }

    override fun getItemCount(): Int = bookItems.size

    class BookHolder(private val binding: FragmentBookItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(book: Book) {
            binding.imgBook.load(data = book.image)
            binding.imgBook.setOnClickListener {
                val dataBundle = Bundle()
                dataBundle.putString(DATE, book.date)
                dataBundle.putString(DESC, book.desc)
                binding.root.findNavController().navigate(R.id.action_bookListFragment_to_detailsFragment, dataBundle)
            }
            binding.book = book
            binding.executePendingBindings()
        }

        companion object{
            const val DATE = "date"
            const val DESC = "desc"
        }

    }
}

data class Book(val image: String, val title: String, val date: String, val desc: String)
