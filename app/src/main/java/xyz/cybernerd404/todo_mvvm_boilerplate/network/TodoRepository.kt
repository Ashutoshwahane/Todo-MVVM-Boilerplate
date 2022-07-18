package xyz.cybernerd404.todo_mvvm_boilerplate.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoRepository {
    suspend fun getTodoList() = withContext(Dispatchers.IO) {
        RetrofitInstance.api.getTodoList()
    }

}