package com.ikhwanizh.recycleviewtutorial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ikhwanizh.recycleviewtutorial.databinding.ItemListBinding

class TodoAdapter(private val viewModel: TodoViewModel): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater, parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoAdapter.TodoViewHolder, position: Int) {
        holder.binding.tvTitle.text = viewModel.todoList.value!![position].title
        holder.binding.tvDesc.text = viewModel.todoList.value!![position].description
        holder.binding.btnDelete.setOnClickListener {
            viewModel.deleteTodo(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, viewModel.todoList.value!!.size)
        }
        //Set Image on RecycleView

    }

    override fun getItemCount(): Int {
        return viewModel.todoList.value!!.size
    }
}