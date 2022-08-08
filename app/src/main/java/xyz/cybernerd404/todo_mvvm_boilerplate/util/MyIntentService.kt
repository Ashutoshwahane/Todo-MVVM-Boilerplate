package xyz.cybernerd404.todo_mvvm_boilerplate.util

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService: IntentService("MyIntentService") {

    companion object {
        private lateinit var instance: MyIntentService
        var isRunning = false

        fun stopService(){
            Log.d("service", "stopService: service is stopping")
            isRunning = false
            instance.stopSelf()
        }
    }

    init {
        instance = this
    }


    override fun onHandleIntent(intent: Intent?) {
        try {
            isRunning = true
            while (isRunning){
                Log.d("service", "onHandleIntent: service is running")
                Thread.sleep(1000)
            }
        } catch (e : InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}