package com.bitcodetech.fragments2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Toast.makeText(activity, "onCreateView : HomeFragment", Toast.LENGTH_SHORT).show()

        val txtHome = TextView(activity)
        txtHome.text = "Home Fragment"
        txtHome.textSize = 40F

        return txtHome
    }

}