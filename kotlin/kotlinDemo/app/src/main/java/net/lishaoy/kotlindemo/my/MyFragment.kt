package net.lishaoy.kotlindemo.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.lishaoy.kotlindemo.R

class MyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val my: View? = inflater.inflate(R.layout.fragment_my, container, false)
        return my ?: super.onCreateView(inflater, container, savedInstanceState)
    }

}