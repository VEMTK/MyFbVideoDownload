package com.szyds.myfbvideodownload.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.szyds.myfbvideodownload.databinding.FragmentFbPageBinding

class FbPageFragment : Fragment() {

    private lateinit var binding: FragmentFbPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFbPageBinding.inflate(inflater, container, false)
        return binding.root
    }
}