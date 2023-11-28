package com.shrutipandit.computercourse.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.shrutipandit.computercourse.R
import com.shrutipandit.computercourse.databinding.FragmentSettingBinding

class SettingFragment : Fragment(R.layout.fragment_setting) {

    private lateinit var binding: FragmentSettingBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingBinding.bind(view)




    }
  }