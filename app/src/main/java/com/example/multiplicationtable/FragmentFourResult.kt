package com.example.multiplicationtable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.multiplicationtable.databinding.FragmentFourResultBinding
import com.example.multiplicationtable.databinding.FragmentOneBinding


class FragmentFourResult : Fragment() {
    private var _binding: FragmentFourResultBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFourResultBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val counter = arguments?.getInt("couterFor4")

        val falseAnswer = 10 - counter!!

        when (falseAnswer) {
            0 -> binding.message.text = "Денис, ты справился с заданьем!!! \nУ тебя нет неправильных ответов."
            1 -> binding.message.text = "Денис, ты справился с заданьем!!! \nУ тебя только $falseAnswer неправильный ответ."
            2 -> binding.message.text = "Денис, ты справился с заданьем!!! \nУ тебя только $falseAnswer неправильных ответов."

            3 -> binding.message.text = "Денис, у тебя средний результат. \nУ тебя $falseAnswer неправильных ответов."
            4 -> binding.message.text = "Денис, у тебя средний результат. \nУ тебя $falseAnswer неправильных ответов."
            5 -> binding.message.text = "Денис, у тебя средний результат. \nУ тебя $falseAnswer неправильных ответов."

            6 -> binding.message.text = "Денис, это провал!!! Тебе нужно больше заниматься. \nУ тебя $falseAnswer неправильных ответов."
            7 -> binding.message.text = "Денис, это провал!!! Тебе нужно больше заниматься. \nУ тебя $falseAnswer неправильных ответов."
            8 -> binding.message.text = "Денис, это провал!!! Тебе нужно больше заниматься. \nУ тебя $falseAnswer неправильных ответов."
            9 -> binding.message.text = "Денис, это провал!!! Тебе нужно больше заниматься. \nУ тебя $falseAnswer неправильных ответов."
            10 -> binding.message.text = "Денис, это провал!!! Тебе нужно больше заниматься. \nУ тебя $falseAnswer неправильных ответов."

        }

        binding.beginNew.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.container, FragmentTwo())
                .commit()
        }


    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}