package com.example.fullscreenmode_application

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [first_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class first_fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first_fragment, container, false)

        val backButton: TextView = view.findViewById(R.id.backButton)
//        val drawable = backButton.background
//        backButton.setTextColor(Color.parseColor("#ffffff"))
//        if (backButton.visibility == View.VISIBLE){
////            backButton.visibility = View.VISIBLE
////            true
//        }
        backButton.setOnTouchListener {_, _ ->
            backButton.setBackgroundColor(Color.parseColor("#ffffff"))
//            val drawable = backButton.background as GradientDrawable
//            drawable.setStroke(1, ContextCompat.getColor(requireContext(), R.color.white))
//
//            backButton.setTextColor(Color.parseColor("#ffffff"))
////            backButton.visibility = View.VISIBLE
            true
        }

        val okButton: TextView = view.findViewById(R.id.okButton)
        okButton.setOnClickListener {
            findNavController().navigate(R.id.action_first_fragment_to_secondFragment)
        }
//        okButton.setOnHoverListener {_, _ ->
//            okButton.visibility = View.VISIBLE
//            true
//        }
//
//        if(okButton.visibility == View.VISIBLE){
//            okButton.setOnClickListener {
//                findNavController().navigate(R.id.action_first_fragment_to_secondFragment)
//            }
//        } else if (okButton.visibility == View.GONE || okButton.visibility == View.INVISIBLE){
//            Log.d("Not Work", "Button did not show on the screen")
//        }
//
//        val bottomNavigation: LinearLayout = view.findViewById(R.id.bottomNavigation)
//        bottomNavigation.setOnHoverListener { _, _ ->
//            bottomNavigation.visibility = View.VISIBLE
//            backButton.visibility = View.VISIBLE
//            okButton.visibility = View.VISIBLE
//            true
//        }
//
//        val firstFragmentView: ConstraintLayout = view.findViewById(R.id.fragment_first_fragment)
//        firstFragmentView.setOnClickListener {
//            findNavController().navigate(R.id.action_first_fragment_to_secondFragment)
//        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment first_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            first_fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}