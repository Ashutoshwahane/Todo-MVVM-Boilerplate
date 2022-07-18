package xyz.cybernerd404.todo_mvvm_boilerplate.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.cybernerd404.todo_mvvm_boilerplate.model.DataResponse
import xyz.cybernerd404.todo_mvvm_boilerplate.network.TodoRepository
import xyz.cybernerd404.todo_mvvm_boilerplate.utils.Resource

class HomeListViewModel(private val repository: TodoRepository): ViewModel() {
    val todoListLiveData: MutableLiveData<Resource<DataResponse>> = MutableLiveData()

    fun getTodoList() = viewModelScope.launch {
        todoListLiveData.postValue(Resource.Loading())
        val response = repository.getTodoList()
        if (response.isSuccessful){
            response.body()?.let { apiResponse ->
                todoListLiveData.postValue(Resource.Success(apiResponse))
            }
        }
    }
}