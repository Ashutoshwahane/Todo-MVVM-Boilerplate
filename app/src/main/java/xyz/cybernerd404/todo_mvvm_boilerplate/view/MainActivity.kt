package xyz.cybernerd404.todo_mvvm_boilerplate.view

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import xyz.cybernerd404.todo_mvvm_boilerplate.databinding.ActivityMainBinding
import xyz.cybernerd404.todo_mvvm_boilerplate.util.AirplaneModelChangeReceiver
import xyz.cybernerd404.todo_mvvm_boilerplate.util.MyIntentService

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {

            loginBtn.setOnClickListener {


                if (mobilNumEt.text.isEmpty() || passwordEt.text.isEmpty()){
                    Toast.makeText(this@MainActivity, "Please enter the login details", Toast.LENGTH_SHORT).show()
                } else /*if (mobilNumEt.text.) */{
                    Toast.makeText(this@MainActivity, "Login Successfull", Toast.LENGTH_SHORT).show()
                }
            }

        }

        binding.mobilNumEt.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                /*TODO("Not yet implemented")*/
            }

            override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("text", "onTextChanged: $p0 and start : $start count : $count")
                binding.loginBtn.isEnabled = binding.mobilNumEt.text.length == 10
            }

            override fun afterTextChanged(p0: Editable?) {
                /*TODO("Not yet implemented")*/
            }

        })

        binding.passwordEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

    }



}