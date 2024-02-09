package xyz.cybernerd404.todo_mvvm_boilerplate.network

import kotlinx.coroutines.*
import xyz.cybernerd404.todo_mvvm_boilerplate.model.DataResponse
import xyz.cybernerd404.todo_mvvm_boilerplate.model.TodoRequest

class TodoRepository {
    suspend fun getTodoList() = withContext(Dispatchers.IO) {
        RetrofitInstance.api.getTodoList()
    }

    suspend fun addTodo(todoRequest: TodoRequest) = withContext(Dispatchers.IO) {
        RetrofitInstance.api.addTodo(todoRequest)
    }

    suspend fun editTodo(todoId: String, todoRequest: TodoRequest) = withContext(Dispatchers.IO) {
        RetrofitInstance.api.editTodo(todoId, todoRequest)
    }

    suspend fun deleteTodo(todoId: String) = withContext(Dispatchers.IO) {
        RetrofitInstance.api.deleteTodo(todoId)
    }



}