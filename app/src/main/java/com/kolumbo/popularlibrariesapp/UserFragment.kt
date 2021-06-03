package com.kolumbo.popularlibrariesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kolumbo.popularlibrariesapp.databinding.FragmentUserBinding
import com.kolumbo.popularlibrariesapp.model.GithubUser
import com.kolumbo.popularlibrariesapp.navigation.BackButtonListener
import com.kolumbo.popularlibrariesapp.presenter.UserPresenter
import com.kolumbo.popularlibrariesapp.view.UserView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UserFragment : MvpAppCompatFragment(), UserView, BackButtonListener {

    companion object {
        private const val USER_ARGUMENT_KEY = "userArgumentKey"

        fun newInstance(user: GithubUser) = UserFragment().apply {
            arguments = Bundle().apply {
                putParcelable(USER_ARGUMENT_KEY, user)
            }
        }
    }

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    private val userPresenter by moxyPresenter {
        val user = arguments?.getParcelable<GithubUser>(USER_ARGUMENT_KEY)
        UserPresenter(user!!, App.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun backPressed() = userPresenter.backPressed()

    override fun showUser(login: String) {
        binding.userLogin.text = login
    }
}