package com.example.multiplicationtable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.multiplicationtable.databinding.FragmentOneBinding
import com.example.multiplicationtable.databinding.FragmentThreeTrueBinding

class FragmentThreeTrue : Fragment() {
    private var _binding: FragmentThreeTrueBinding? = null
    private val binding get() = _binding!!

    var listAnswerTrueFoto = mutableListOf(
        R.drawable.at39,
        R.drawable.at40,
        R.drawable.at41,
        R.drawable.at42,
        R.drawable.at43,
        R.drawable.at44,
        R.drawable.at45,
        R.drawable.at46,
        R.drawable.at47,
        R.drawable.at48,
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThreeTrueBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var foto = listAnswerTrueFoto.random()
        binding.fotoAnwerTrue.setImageResource(foto)

        binding.next.setOnClickListener {
            parentFragmentManager.popBackStack()
//            parentFragmentManager.beginTransaction().replace(R.id.container, FragmentTwo()).commit()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }




}