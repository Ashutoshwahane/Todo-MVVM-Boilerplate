package xyz.cybernerd404.todo_mvvm_boilerplate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import xyz.cybernerd404.todo_mvvm_boilerplate.databinding.TodoItemLayoutBinding
import xyz.cybernerd404.todo_mvvm_boilerplate.model.Data
import xyz.cybernerd404.todo_mvvm_boilerplate.utils.Listener


class TodoListAdapter(private val listener: Listener) : RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {
    private var list: List<Data> = arrayListOf()

    fun setList(response: List<Data>) {
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
        holder.binding.todoTv.text = list[position].todo
        holder.binding.root.setOnClickListener {
            listener.clickListener(list[position])
        }

    }


    class ViewHolder(val binding: TodoItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

}