package xyz.cybernerd404.todo_mvvm_boilerplate.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.cybernerd404.todo_mvvm_boilerplate.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}