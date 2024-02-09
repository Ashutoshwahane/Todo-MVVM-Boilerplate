package xyz.cybernerd404.todo_mvvm_boilerplate.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import xyz.cybernerd404.todo_mvvm_boilerplate.adapter.TodoListAdapter
import xyz.cybernerd404.todo_mvvm_boilerplate.databinding.FragmentHomeListBinding
import xyz.cybernerd404.todo_mvvm_boilerplate.model.Data
import xyz.cybernerd404.todo_mvvm_boilerplate.model.TodoRequest
import xyz.cybernerd404.todo_mvvm_boilerplate.utils.Listener
import xyz.cybernerd404.todo_mvvm_boilerplate.utils.Resource
import xyz.cybernerd404.todo_mvvm_boilerplate.utils.debug


class HomeListFragment : Fragment(), Listener {
    private lateinit var binding: FragmentHomeListBinding
    private lateinit var viewModel: HomeListViewModel
    private lateinit var adapter: TodoListAdapter
    private lateinit var list: MutableList<Data>
    private lateinit var todoEt: EditText
    private lateinit var todoTv : TextView
    private lateinit var addTodo: Button
    private lateinit var bottomSheetDialog: BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        adapter = TodoListAdapter(this)
        list = mutableListOf()
        bottomSheetDialog = BottomSheetDialog(requireContext())
        binding.apply {
            todoRv.layoutManager = LinearLayoutManager(requireContext())
            todoRv.adapter = adapter
        }




        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                /*val article = newsAdatper.differ.currentList[position]
                viewModel.deleteArticle(article)*/
                val item = list.get(position)
                viewModel.deleteTodo(item._id)
                Toast.makeText(activity, "Successfully deleted article", Toast.LENGTH_SHORT).show()
            }

        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding.todoRv)
        }

        viewModel.deleteTodoLiveData.observe(viewLifecycleOwner) {
            viewModel.getTodoList()
        }

        binding.addTodoBtn.setOnClickListener {
            showBottomSheetDialog()
        }


    }

    override fun onResume() {
        super.onResume()

        viewModel.getTodoList()
        viewModel.todoListLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    debug("response : ${it.data}")
                    adapter.setList(it.data!!.data)
                    it.data.data.forEach {
                        list.add(it)
                    }
                }

                is Resource.Error -> {
                    debug("error : ${it.message}")
                }
            }
        }
    }


    private fun showBottomSheetDialog() {
        bottomSheetDialog.setContentView(xyz.cybernerd404.todo_mvvm_boilerplate.R.layout.add_todo_bottomsheet)
        todoEt =
            bottomSheetDialog.findViewById<EditText>(xyz.cybernerd404.todo_mvvm_boilerplate.R.id.todoEt)!!
        todoTv = bottomSheetDialog.findViewById<TextView>(xyz.cybernerd404.todo_mvvm_boilerplate.R.id.titleTv)!!

        addTodo =
            bottomSheetDialog.findViewById<Button>(xyz.cybernerd404.todo_mvvm_boilerplate.R.id.addTodoBt)!!
        bottomSheetDialog.show()
        todoTv.text = "add Todo"
        addTodo.text = "add Todo"

        addTodo.setOnClickListener {
            if (todoEt.text.isEmpty()) {
                Toast.makeText(requireContext(), "please add text to todo", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val todoRequest = TodoRequest(todoEt.text.toString(), true)
                viewModel.addTodo(todoRequest)
                bottomSheetDialog.dismiss()
                viewModel.getTodoList()
            }
        }

    }

    override fun clickListener(data: Data) {
        updateTodo(data)
    }

    private fun updateTodo(data: Data) {
        bottomSheetDialog.setContentView(xyz.cybernerd404.todo_mvvm_boilerplate.R.layout.add_todo_bottomsheet)
        todoEt =
            bottomSheetDialog.findViewById<EditText>(xyz.cybernerd404.todo_mvvm_boilerplate.R.id.todoEt)!!
        todoTv = bottomSheetDialog.findViewById<TextView>(xyz.cybernerd404.todo_mvvm_boilerplate.R.id.titleTv)!!

        addTodo =
            bottomSheetDialog.findViewById<Button>(xyz.cybernerd404.todo_mvvm_boilerplate.R.id.addTodoBt)!!
        bottomSheetDialog.show()
        todoTv.text = "update Todo"
        addTodo.text = "update Todo"
        todoEt.setText(data.todo)
        addTodo.setOnClickListener {
            if (todoEt.text.isEmpty()) {
                Toast.makeText(requireContext(), "please add text to todo", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val todoRequest = TodoRequest(todoEt.text.toString(), true)
                viewModel.editTodo(data._id,todoRequest)
                bottomSheetDialog.dismiss()
                viewModel.getTodoList()
            }
        }

    }


}