package com.shrutipandit.computercourse.ui

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.shrutipandit.computercourse.R
import com.shrutipandit.computercourse.databinding.FragmentSeenVideosBinding

class SeenVideosFragment : Fragment(R.layout.fragment_seen_videos) {
    private lateinit var binding: FragmentSeenVideosBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSeenVideosBinding.bind(view)


    }
}
