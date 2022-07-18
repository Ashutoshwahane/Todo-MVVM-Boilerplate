package xyz.cybernerd404.todo_mvvm_boilerplate.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import xyz.cybernerd404.todo_mvvm_boilerplate.network.TodoRepository
import xyz.cybernerd404.todo_mvvm_boilerplate.view.HomeListViewModel

class TodoModelProviderFactory(val repository: TodoRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeListViewModel(repository) as T
    }
}