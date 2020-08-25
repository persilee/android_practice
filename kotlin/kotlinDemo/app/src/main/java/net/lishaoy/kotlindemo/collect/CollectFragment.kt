package net.lishaoy.kotlindemo.collect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.lishaoy.kotlindemo.R

class CollectFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val collect: View? = inflater.inflate(R.layout.fragment_collect, container, false)
        return collect ?: super.onCreateView(inflater, container, savedInstanceState)
    }

}