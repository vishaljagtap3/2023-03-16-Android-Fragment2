package com.bitcodetech.fragments2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var loginFragment: LoginFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupListeners()
    }

    private fun setupListeners() {
        loginFragment.onLoginListener = MyOnLoginListener()

        /*loginFragment.onLoginListener =
            object : LoginFragment.OnLoginListener {
                override fun onSuccess(loginFragment: LoginFragment) {
                    TODO("Not yet implemented")
                }

                override fun onFailed(loginFragment: LoginFragment) {
                    TODO("Not yet implemented")
                }
            }*/

    }

    inner class MyOnLoginListener : LoginFragment.OnLoginListener {
        override fun onSuccess(loginFragment: LoginFragment) {
            mt("MA: Success")

            //remove login fragment, add home fragment
            val homeFragment = HomeFragment()

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.remove(loginFragment)
            fragmentTransaction.add(R.id.mainContainer, homeFragment, "homefragment")
            fragmentTransaction.commit()


            /*supportFragmentManager.beginTransaction()
                .remove(loginFragment)
                .commit()

            //add home fragment
            val homeFragment = HomeFragment()

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.mainContainer, homeFragment, "homefragment")
            fragmentTransaction.commit()*/


        }

        override fun onFailed(loginFragment: LoginFragment) {
            mt("MA: Failed")
        }
    }

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun initViews() {
        loginFragment = supportFragmentManager.findFragmentById(R.id.loginFragment) as LoginFragment
    }
}