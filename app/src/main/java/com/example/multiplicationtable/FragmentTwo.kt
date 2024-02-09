package com.example.multiplicationtable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.multiplicationtable.databinding.FragmentOneBinding
import com.example.multiplicationtable.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {
    private var _binding: FragmentTwoBinding? = null
    private val binding get() = _binding!!

    var counterTrueAnwers = 0
    var counterAnwers = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTwoBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.counter.text = counterAnwers.toString()

        if (counterAnwers == 10) {
            parentFragmentManager.beginTransaction().replace(R.id.container, FragmentFourResult()).commit()
        }

        val oneM = (1..9).random()
        val twoM = (1..9).random()
        val result = oneM * twoM

        binding.changeButton.isEnabled = false



        binding.quation.text = "$oneM x $twoM = "

        binding.answer.addTextChangedListener { openButton() }

        binding.changeButton.setOnClickListener {
            counterAnwers++
            if (binding.answer.getText().toString() == result.toString()) {
                counterTrueAnwers ++
                val bundle = Bundle()
//            val bundle = bundleOf("feedback" to feedback)

                bundle.putString("counterAnwers", counterAnwers.toString())

                parentFragmentManager.beginTransaction().replace(R.id.container, FragmentThreeTrue(), bundle).commit()

            }
            else parentFragmentManager.beginTransaction().replace(R.id.container, FragmentThreeFalse()).commit()

        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    fun openButton() {
        if (binding.answer.text.isDigitsOnly() && binding.answer.getText().toString() != "") {
            binding.changeButton.isEnabled = true
        } else binding.changeButton.isEnabled = false
    }
}