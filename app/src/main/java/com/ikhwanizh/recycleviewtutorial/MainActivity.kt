package com.ikhwanizh.recycleviewtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ikhwanizh.recycleviewtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewAdapter: TodoAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[TodoViewModel::class.java]
        viewManager = LinearLayoutManager(this)
        viewAdapter = TodoAdapter(viewModel)

        binding.rvList.apply{
            layoutManager = viewManager
            adapter = viewAdapter
        }

        binding.btnAdd.setOnClickListener {
            viewModel.addTodo(
                binding.etTitle.text.toString(),
            )
            viewAdapter.notifyDataSetChanged()
            binding.etTitle.text.clear()
        }
    }
}