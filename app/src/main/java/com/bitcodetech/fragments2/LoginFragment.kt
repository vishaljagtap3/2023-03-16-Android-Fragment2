package com.bitcodetech.fragments2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {

    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button

    interface OnLoginListener {
        fun onSuccess(loginFragment: LoginFragment)
        fun onFailed(loginFragment: LoginFragment)
    }

    var onLoginListener: OnLoginListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.login_fragment, null)

        initViews(view)
        setupListeners()

        return view
    }

    private fun setupListeners() {

        btnLogin.setOnClickListener {
            if (onLoginListener == null) {
                return@setOnClickListener
            }

            if (edtUsername.text.toString().equals("bitcode") && edtPassword.text.toString()
                    .equals("bitcode")
            ) {
                onLoginListener!!.onSuccess(this@LoginFragment)
            } else {
                onLoginListener!!.onFailed(this@LoginFragment)
            }
        }


        /*btnLogin.setOnClickListener {

            if(edtUsername.text.toString().equals("bitcode") && edtPassword.text.toString().equals("bitcode")) {
                mt("Login Successful!")
            }
            else {
                mt("Login failed!")
            }
        }*/

    }

    private fun mt(text: String) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }

    private fun initViews(view: View) {
        edtUsername = view.findViewById(R.id.edtUsername)
        edtPassword = view.findViewById(R.id.edtPassword)
        btnLogin = view.findViewById(R.id.btnLogin)
    }

}