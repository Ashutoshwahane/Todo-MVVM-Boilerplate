package xyz.cybernerd404.todo_mvvm_boilerplate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import xyz.cybernerd404.todo_mvvm_boilerplate.databinding.TodoItemLayoutBinding
import xyz.cybernerd404.todo_mvvm_boilerplate.model.DataResponse


class TodoListAdapter() : RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {
    private var list: List<DataResponse> = arrayListOf()

    fun setList(response: List<DataResponse>) {
        this.list = response
        notifyDataSetChanged()


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TodoItemLayoutBinding.inflate(
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
        holder.binding.todoTv.text = list[position].data[position].todo

    }


    class ViewHolder(val binding: TodoItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

}