package xyz.cybernerd404.todo_mvvm_boilerplate.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.cybernerd404.todo_mvvm_boilerplate.databinding.ActivityFirstBinding
import xyz.cybernerd404.todo_mvvm_boilerplate.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}