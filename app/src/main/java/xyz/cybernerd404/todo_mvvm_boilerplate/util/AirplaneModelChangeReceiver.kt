package xyz.cybernerd404.todo_mvvm_boilerplate.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModelChangeReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isEnable = intent?.getBooleanExtra("state", false)  ?: return

        if (isEnable){
            Toast.makeText(context, "Airplane Mode Enable", Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(context, "Airplane mode Disable", Toast.LENGTH_SHORT).show()
        }
    }
}