package com.ikhwanizh.recycleviewtutorial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel: ViewModel() {
    private val _todoList = MutableLiveData<ArrayList<ToDo>>()
    val todoList: MutableLiveData<ArrayList<ToDo>> = _todoList

    init {
        _todoList.value = arrayListOf(
            ToDo(
                id = 1,
                title = "Todo 1",
                description = "Description 1"
            ),
            ToDo(
                id = 2,
                title = "Todo 2",
                description = "Description 2"
            ),
            ToDo(
                id = 3,
                title = "Todo 3",
                description = "Description 3"
            )
        )
    }

    fun addTodo(title:String) {
        _todoList.value!!.add(ToDo(
            id = _todoList.value!!.size + 1,
            title = title,
            description = "Description ${_todoList.value!!.size + 1}"
        ))
    }

    fun deleteTodo(position: Int) {
        _todoList.value!!.removeAt(position)
    }
}