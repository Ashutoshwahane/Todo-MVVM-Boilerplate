package xyz.cybernerd404.todo_mvvm_boilerplate.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xyz.cybernerd404.todo_mvvm_boilerplate.databinding.FragmentHomeListBinding


class HomeListFragment : Fragment() {
    private lateinit var binding: FragmentHomeListBinding
    private lateinit var viewModel: HomeListViewModel
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

        viewModel.getTodoList()

    }


}