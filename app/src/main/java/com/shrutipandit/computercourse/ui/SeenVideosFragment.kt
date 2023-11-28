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
    private lateinit var videoView: VideoView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSeenVideosBinding.bind(view)

        // Initialize VideoView
        videoView = binding.videoView

        // Specify the location of the video file
        val videoPath = "android.resource://" + requireContext().packageName + "/" + R.raw.winner_animation

        // Set the video URI
        val videoUri = Uri.parse(videoPath)
        videoView.setVideoURI(videoUri)

        // Create a MediaController for the VideoView
        val mediaController = MediaController(requireContext())
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Start playing the video
        videoView.start()
    }
}
