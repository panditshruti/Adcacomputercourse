package com.shrutipandit.computercourse.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.shrutipandit.computercourse.R
import com.shrutipandit.computercourse.databinding.FragmentChapterDetailsBinding
import com.shrutipandit.computercourse.databinding.FragmentQueuesListBinding

class queues_list : Fragment(R.layout.fragment_queues_list) {

    private lateinit var binding: FragmentQueuesListBinding
    private lateinit var arrayList: ArrayList<String>
    private lateinit var arrayAdapter: ArrayAdapter<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentQueuesListBinding.bind(view)



        arrayList = arrayListOf()
        arrayList.add("Ch-1 Computer Fundamental")
        arrayList.add("Ch-2 Ms.Windows")
        arrayList.add("Ch-3 Notepad")
        arrayList.add("Ch-4 WordPad")
        arrayList.add("Ch-5 Paint")
        arrayList.add("Ch-6 Ms.Office")
        arrayList.add("Ch-7 Ms.Word")
        arrayList.add("Ch-8 Ms.Excel")
        arrayList.add("Ch-9 Ms.Power Point")
        arrayList.add("Ch-10 Internet")
        arrayList.add("Ch-11 Publisher")
        arrayList.add("Ch-12 Tally")
        arrayList.add("Ch-13 PageMaker")
        arrayList.add("Ch-14 Photoshop")
        arrayList.add("Ch-15 Corel Drow")
        arrayList.add("Ch-16 Short Keys")
        arrayList.add("Ch-17 FullForm")
        arrayList.add("Ch-18 Symbol")

        arrayAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, arrayList)

        binding.listview.adapter = arrayAdapter

        binding.listview.setOnItemClickListener { _, _, position,_  ->

            val chNo = position.plus(1)
            val action = queues_listDirections.actionQueuesListToQueueSeen()
            findNavController().navigate(action)

        }
        arrayAdapter.notifyDataSetChanged()

    }

}


