package com.shrutipandit.computercourse.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.shrutipandit.computercourse.R
import com.shrutipandit.computercourse.adapter.ImageSliderAdapter
import com.shrutipandit.computercourse.databinding.ActivityMainBinding
import com.shrutipandit.computercourse.databinding.FragmentHomeBinding
import java.util.Timer
import java.util.TimerTask
class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    private lateinit var viewPager: ViewPager
    private lateinit var imageSliderAdapter: ImageSliderAdapter
    private val images = intArrayOf(
        R.drawable.pbg1,
        R.drawable.bb1,
        R.drawable.bb2,
        R.drawable.bb4,
        R.drawable.bb3
    )
    // Timer and handler for auto-scrolling
    private var currentPage = 0
    private val DELAY_MS: Long = 3000 // Delay in milliseconds before the next page is shown.
    private val PERIOD_MS: Long = 3000 // Interval time to repeat.

    private val handler = Handler(Looper.getMainLooper())
    private val update = Runnable {
        if (currentPage == images.size) {
            currentPage = 0
        }
        viewPager.setCurrentItem(currentPage++, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentHomeBinding.bind(view)

        // Corrected binding for viewPager
        viewPager = binding.viewPager
        imageSliderAdapter = ImageSliderAdapter(requireContext(), images)
        viewPager.adapter = imageSliderAdapter

        // Set up auto-scrolling
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
            }
        }, DELAY_MS, PERIOD_MS)

        binding.notes.setOnClickListener {
            val action = HomeFragmentDirections.actionHome2ToChapterDetailsFragment()
            findNavController().navigate(action)
        }

        binding.videos.setOnClickListener {
            val action = HomeFragmentDirections. actionHome2ToVideos()
            findNavController().navigate(action)

        }

        binding.certificate.setOnClickListener {
            val action = HomeFragmentDirections.actionHome2ToCertificate()
            findNavController().navigate(action)

        }

        binding.queues.setOnClickListener {
            val action = HomeFragmentDirections.actionHome2ToQueuesList()
            findNavController().navigate(action)

        }
    }
}
