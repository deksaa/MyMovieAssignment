package com.mobven.moviesapplication.fragment.upcomingFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mobven.moviesapplication.R

class UpComingFragment : Fragment() {

    companion object {
        fun newInstance() = UpComingFragment()
    }

    private lateinit var viewModel: UpComingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.setRetainInstance(true)
        return inflater.inflate(R.layout.up_coming_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UpComingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
