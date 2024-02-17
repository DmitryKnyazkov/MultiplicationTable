package com.example.multiplicationtable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.multiplicationtable.databinding.FragmentThreeFalseBinding
import com.example.multiplicationtable.databinding.FragmentThreeTrueBinding

class FragmentThreeFalse : Fragment() {
    private var _binding: FragmentThreeFalseBinding? = null
    private val binding get() = _binding!!
    var listAnswerFalseFoto = mutableListOf(
        R.drawable.af29,
        R.drawable.af30,
        R.drawable.af31,
        R.drawable.af32,
        R.drawable.af33,
        R.drawable.af34,
        R.drawable.af35,
        R.drawable.af36,
        R.drawable.af37,
        R.drawable.af38
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThreeFalseBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val result = arguments?.getString("trueResult")

        var foto = listAnswerFalseFoto.random()
        binding.fotoAnwerFalse.setImageResource(foto)

        binding.fr3.text = "Правильный ответ $result!!!"
        binding.nextF.setOnClickListener {
            parentFragmentManager.popBackStack()
//            parentFragmentManager.beginTransaction().replace(R.id.container, FragmentTwo()).commit()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}




