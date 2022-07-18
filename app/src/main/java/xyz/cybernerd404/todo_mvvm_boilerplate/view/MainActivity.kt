package xyz.cybernerd404.todo_mvvm_boilerplate.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import xyz.cybernerd404.todo_mvvm_boilerplate.R
import xyz.cybernerd404.todo_mvvm_boilerplate.databinding.ActivityMainBinding
import xyz.cybernerd404.todo_mvvm_boilerplate.network.TodoRepository
import xyz.cybernerd404.todo_mvvm_boilerplate.utils.TodoModelProviderFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: HomeListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = TodoRepository()
        val factory = TodoModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(HomeListViewModel::class.java)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(binding.fragmentContainerView.id, HomeListFragment())
            }
        }

    }
}