package com.shrutipandit.computercourse.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import com.shrutipandit.computercourse.R
import com.shrutipandit.computercourse.databinding.FragmentTypingBinding


class TypingFragment : Fragment(R.layout.fragment_typing) {

    private lateinit var binding: FragmentTypingBinding
    private lateinit var arrayList: ArrayList<String>
    private lateinit var arrayAdapter: ArrayAdapter<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTypingBinding.bind(view)

//        arrayList = arrayListOf()
//        arrayList.add("Ch-1 Computer Fundamental")
//        arrayList.add("Ch-2 Ms.Windows")
//        arrayList.add("Ch-3 Notepad")
//        arrayList.add("Ch-4 WordPad")
//        arrayList.add("Ch-5 Paint")
//        arrayList.add("Ch-6 Ms.Office")
//        arrayList.add("Ch-7 Ms.Word")
//        arrayList.add("Ch-8 Ms.Excel")
//        arrayList.add("Ch-9 Ms.Power Point")
//        arrayList.add("Ch-10 Internet")
//        arrayList.add("Ch-11 Publisher")
//        arrayList.add("Ch-12 Tally")
//        arrayList.add("Ch-13 PageMaker")
//        arrayList.add("Ch-14 Photoshop")
//        arrayList.add("Ch-15 Corel Drow")
//        arrayList.add("Ch-16 Short Keys")
//        arrayList.add("Ch-17 FullForm")
//        arrayList.add("Ch-18 Symbol")
//
//        arrayAdapter =
//            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, arrayList)
//
//        binding.listview.adapter = arrayAdapter
//
//        binding.listview.setOnItemClickListener { _, _, position,_  ->
//
//            val chNo = position.plus(1)
//            val action = CertificateFragmentDirections.actionCertificateToTestQuestionFragment()
//            findNavController().navigate(action)
//
//        }
//        arrayAdapter.notifyDataSetChanged()
//
//        binding.createCertificateBtn.setOnClickListener {
//
//            val action = CertificateFragmentDirections.action_certificate_to_queue_list3()
//            findNavController().navigate(action)
//
//        }


        }


    }








