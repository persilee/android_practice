package net.lishaoy.kotlindemo.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.lishaoy.kotlindemo.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val home: View? = inflater.inflate(R.layout.fragment_home, container, false)
        return home ?: super.onCreateView(inflater, container, savedInstanceState)
    }

}