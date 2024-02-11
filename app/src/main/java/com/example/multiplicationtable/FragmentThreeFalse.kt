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

        val getInfo = arguments?.getString("counterAnwers")
        binding.fr3.text = getInfo.toString()

//        val bundleTo2 = Bundle()
//        bundleTo2.putString("counterAnwers", getInfo.toString())

//        val fragment2 = FragmentTwo()
//        fragment2.arguments = bundleTo2
//        parentFragmentManager.beginTransaction().replace(R.id.container, FragmentThreeTrue()).commit()

        binding.nextF.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.container, FragmentTwo()).commit()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}




