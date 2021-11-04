package com.example.fullscreenmode_application

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val secondFragmentView: ConstraintLayout = view.findViewById(R.id.fragment_second_fragment)
        val secondFragmentButton: TextView = view.findViewById(R.id.secondFragmentButton)

        secondFragmentButton.setOnClickListener {
            val customSnackBar = Snackbar.make(secondFragmentView, "", Snackbar.LENGTH_LONG)
            val layout = customSnackBar.view as Snackbar.SnackbarLayout

            val customSnackBarView = layoutInflater.inflate(
                R.layout.custom_snack_view,
                view.findViewById<View>(R.id.custom_snackBar_container) as? ViewGroup
            )

            val textView = customSnackBarView.findViewById<TextView>(R.id.customSnackText)

            textView.text = resources.getText(R.string.stringExampleSnackView)
            layout.setPadding(0, 0, 0, 0)

            layout.addView(customSnackBarView, 0)
            customSnackBar.duration = 4000
            customSnackBar.show()
//            createSnackBar(it)
//            val customSnackBar: Snackbar = Snackbar.make(con)
//            findNavController().navigate(R.id.action_secondFragment_to_first_fragment)
        }

        return view
    }

    @SuppressLint("InflateParams", "SetTextI18n")
    private fun createToast() {
        val view1 = layoutInflater.inflate(R.layout.toast_border, null)
        view1.setBackgroundResource(android.R.drawable.toast_frame)
        val toastText: TextView = view1.findViewById(R.id.toastText)

        val stringResult = "Very Good"
        toastText.text = stringResult.lowercase(Locale.getDefault())

        val toast = Toast(this.activity).apply {
            duration = Toast.LENGTH_LONG
            setGravity(Gravity.NO_GRAVITY, 0, 500)
            view = view1
        }

        val countDownTimer = object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                toast.cancel()
            }
        }

        toast.show()
        countDownTimer.start()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}