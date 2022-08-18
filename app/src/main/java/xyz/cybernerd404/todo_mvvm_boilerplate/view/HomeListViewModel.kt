package xyz.cybernerd404.todo_mvvm_boilerplate.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.cybernerd404.todo_mvvm_boilerplate.model.DataResponse
import xyz.cybernerd404.todo_mvvm_boilerplate.model.TodoEditDeleteResponse
import xyz.cybernerd404.todo_mvvm_boilerplate.model.TodoRequest
import xyz.cybernerd404.todo_mvvm_boilerplate.model.TodoResponse
import xyz.cybernerd404.todo_mvvm_boilerplate.network.TodoRepository
import xyz.cybernerd404.todo_mvvm_boilerplate.utils.Resource

class HomeListViewModel(private val repository: TodoRepository): ViewModel() {
    val todoListLiveData: MutableLiveData<Resource<DataResponse>> = MutableLiveData()
    val addTodoLiveData: MutableLiveData<Resource<TodoResponse>> = MutableLiveData()
    val deleteTodoLiveData: MutableLiveData<Resource<TodoEditDeleteResponse>> = MutableLiveData()

    fun getTodoList() = viewModelScope.launch {
        todoListLiveData.postValue(Resource.Loading())
        val response = repository.getTodoList()
        if (response.isSuccessful){
            response.body()?.let { apiResponse ->
                todoListLiveData.postValue(Resource.Success(apiResponse))
            }
        }else {
            todoListLiveData.postValue(Resource.Error(response.message()))
        }
    }

    fun addTodo(todoRequest: TodoRequest) = viewModelScope.launch {
        addTodoLiveData.postValue(Resource.Loading())
        val response = repository.addTodo(todoRequest)
        if (response.isSuccessful){
            response.body()?.let { apiResponse ->
                addTodoLiveData.postValue(Resource.Success(apiResponse))
            }
        }else {
            addTodoLiveData.postValue(Resource.Error(response.message()))
        }
    }

    fun editTodo(todoId: String, todoRequest: TodoRequest) = viewModelScope.launch {
        addTodoLiveData.postValue(Resource.Loading())
        val response = repository.editTodo(todoId, todoRequest)
        if (response.isSuccessful){
            response.body()?.let { apiResponse ->
                addTodoLiveData.postValue(Resource.Success(apiResponse))
            }
        }else {
            addTodoLiveData.postValue(Resource.Error(response.message()))
        }
    }

    fun deleteTodo(todoId: String) = viewModelScope.launch {
        deleteTodoLiveData.postValue(Resource.Loading())
        val response = repository.deleteTodo(todoId)
        
        if (response.isSuccessful){
            response.body()?.let { apiResponse ->
                deleteTodoLiveData.postValue(Resource.Success(apiResponse))
            }
        }else {
            deleteTodoLiveData.postValue(Resource.Error(response.message()))
        }
    }



}