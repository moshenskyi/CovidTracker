package com.moshenskyi.sign_in

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class SignInFragment : Fragment(R.layout.sign_in_fragment) {

    private val viewModel by viewModels<SignInViewModel> { defaultViewModelProviderFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}