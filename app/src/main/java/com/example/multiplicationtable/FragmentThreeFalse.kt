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
        val getInfo = 5
        binding.fr3.text = getInfo.toString()


        binding.nextF.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.container, FragmentTwo()).commit()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}




