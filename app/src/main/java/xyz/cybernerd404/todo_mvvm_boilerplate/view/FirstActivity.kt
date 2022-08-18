package xyz.cybernerd404.todo_mvvm_boilerplate.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.cybernerd404.todo_mvvm_boilerplate.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}