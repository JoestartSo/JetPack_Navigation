package com.example.jetpack_navigationtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions

class fragment_home : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    val options = navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //unsafe args passing from one fragment to the next fragment
        val textUnsafeArg=view.findViewById<EditText>(R.id.text_unsafe_arg)
        val textSafeArg=view.findViewById<EditText>(R.id.text_safe_arg)
        val button=view.findViewById<Button>(R.id.button_home)

        button.setOnClickListener{
            val unsafeArg:String=textUnsafeArg.text.toString()
            val safeArg:String=textSafeArg.text.toString()
            var mBundle: Bundle = bundleOf("unsafeArg" to unsafeArg, "safeArg" to safeArg)
            findNavController().navigate(R.id.fragment01,mBundle,options)
        }
    }
}
