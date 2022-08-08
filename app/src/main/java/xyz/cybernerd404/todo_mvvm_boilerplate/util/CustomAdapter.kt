package xyz.cybernerd404.todo_mvvm_boilerplate.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import xyz.cybernerd404.todo_mvvm_boilerplate.databinding.ActivityMainBinding


class CustomAdapter() : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private var list: List<Any> = arrayListOf()

    fun setList(response: List<Any>) {
        this.list = response
        notifyDataSetChanged()


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ActivityMainBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


    }


    class ViewHolder(val binding: ActivityMainBinding) :
        RecyclerView.ViewHolder(binding.root)

}