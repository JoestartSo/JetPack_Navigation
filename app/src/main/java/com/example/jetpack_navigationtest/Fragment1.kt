package com.example.jetpack_navigationtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class Fragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragmenttv
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var unsafeArg: String = arguments?.getString("unsafeArg")?:""
        var safeArg: String = arguments?.getString("safeArg")?:""
        val tvUnsafeArg=view.findViewById<TextView>(R.id.tv_unsafe_arg)
        val tvSafeArg=view.findViewById<TextView>(R.id.tv_safe_arg)
        tvUnsafeArg.setText("$unsafeArg")
        tvSafeArg.setText("$safeArg")


        val button=view.findViewById<Button>(R.id.button1)
        button.setOnClickListener{
            findNavController().navigate(R.id.action_fragment1_to_fragment2)
        }
    }
}
