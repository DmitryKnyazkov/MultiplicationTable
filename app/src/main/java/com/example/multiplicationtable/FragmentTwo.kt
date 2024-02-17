package com.example.multiplicationtable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
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
    var listQuationFoto = mutableListOf(
        R.drawable.q19,
        R.drawable.q20,
        R.drawable.q21,
        R.drawable.q22,
        R.drawable.q23,
        R.drawable.q24,
        R.drawable.q25,
        R.drawable.q26,
        R.drawable.q27,
        R.drawable.q28,
    )

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


        if (counterAnwers == 10) {
            val counterBundle = bundleOf("couterFor4" to counterTrueAnwers)

            val fragment4 = FragmentFourResult()
            fragment4.arguments = counterBundle

            parentFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, fragment4).commit()
        }

        val oneM = (2..9).random()
        val twoM = (2..9).random()
        val result = oneM * twoM

        val strResult = "$oneM x $twoM = $result"


        binding.changeButton.isEnabled = false


        binding.counter.text = "$counterAnwers/10"

        binding.quation.text = "$oneM x $twoM = "

        var foto = listQuationFoto.random()
        binding.denisFoto.setImageResource(foto)

        binding.answer.addTextChangedListener { openButton() }

        binding.changeButton.setOnClickListener {
            counterAnwers++

            if (binding.answer.getText().toString() == result.toString()) {
                binding.answer.setText("")
                counterTrueAnwers ++

                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, FragmentThreeTrue()).commit()

            }
            else {
                binding.answer.setText("")

                val forBundle = bundleOf("trueResult" to strResult)

                val fragmentThreeFalse = FragmentThreeFalse()
                fragmentThreeFalse.arguments = forBundle
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, fragmentThreeFalse).commit()
            }



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