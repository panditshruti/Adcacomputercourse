package com.shrutipandit.computercourse.ui

import android.app.AlertDialog
import android.os.Bundle
import android.support.media.ExifInterface.IfdType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.lottie.Lottie
import com.airbnb.lottie.LottieAnimationView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.shrutipandit.computercourse.R
import com.shrutipandit.computercourse.databinding.FragmentQueuesSeenBinding
import com.shrutipandit.computercourse.list.Gk

class Queues_SeenFragment : Fragment(R.layout.fragment_queues__seen) {
    private lateinit var binding :FragmentQueuesSeenBinding
        private lateinit var arrayList: ArrayList<Gk>
        private lateinit var db: DatabaseReference


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            binding = FragmentQueuesSeenBinding.bind(view)

            db = FirebaseDatabase.getInstance().reference.child("queues Questions")

            arrayList = arrayListOf()
            arrayList.add(Gk("A byte consists of 8 bits.", true))
            arrayList.add(Gk("RAM is a type of permanent memory.", false))
            arrayList.add(Gk("Python is a compiled programming language.", false))
            arrayList.add(Gk("The CPU is responsible for executing instructions.", true))
            arrayList.add(Gk("A router is used to connect devices in a network.", true))
            arrayList.add(Gk("An SSD is faster than an HDD.", true))
            arrayList.add(Gk("Linux is an open-source operating system.", true))
            arrayList.add(Gk("HTTP stands for Hypertext Transfer Protocol.", true))
            arrayList.add(Gk("Java is a low-level programming language.", false))
            arrayList.add(Gk("Cloud computing involves the use of physical servers.", false))
            arrayList.add(Gk("A byte consists of 8 bits.", true))
            arrayList.add(Gk("RAM is a type of permanent memory.", false))
            arrayList.add(Gk("Python is a compiled programming language.", false))
            arrayList.add(Gk("The CPU is responsible for executing instructions.", true))
            arrayList.add(Gk("A router is used to connect devices in a network.", true))
            arrayList.add(Gk("An SSD is faster than an HDD.", true))
            arrayList.add(Gk("Linux is an open-source operating system.", true))
            arrayList.add(Gk("HTTP stands for Hypertext Transfer Protocol.", true))
            arrayList.add(Gk("Java           is a low-level programming language.", false))
            arrayList.add(Gk("Cloud computing involves the use of physical servers.", false))
            arrayList.add(Gk("RAM is a type of permanent memory.", false))
            arrayList.add(Gk("Python is a compiled programming language.", false))
            arrayList.add(Gk("The CPU is responsible for executing instructions.", true))
            arrayList.add(Gk("A router is used to connect devices in a network.", true))
            arrayList.add(Gk("An SSD is faster than an HDD.", true))
            arrayList.add(Gk("Linux is an open-source operating system.", true))
            arrayList.add(Gk("HTTP stands for Hypertext Transfer Protocol.", true))
            arrayList.add(Gk("Java is a low-level programming language.", false))
            arrayList.add(Gk("Cloud computing involves the use of physical servers.", false))

            for (a in 0 until arrayList.size){
                db.child("ch1").child(a.toString()).setValue(Gk(arrayList[a].question,arrayList[a].answer))
            }

            var userScore = 0
            var questionIndex = 0
            binding.tvQuestion.text = arrayList[questionIndex].question

            binding.nextbtn.setOnClickListener {

                if(questionIndex<arrayList.size) {
                    var selectedAnswer = false
                    binding.tvQuestion.text = arrayList[questionIndex].question

                    if (binding.trueCheckBox.isChecked) {
                        selectedAnswer = true
                    }
                    if (binding.falseCheckBox.isChecked) {
                        selectedAnswer = false
                    }

                    if (selectedAnswer == arrayList[questionIndex].answer) {


                        userScore++

                        binding.rightScore.visibility = View.VISIBLE
                        binding.rightScore.text = userScore.toString()

                    }

                    questionIndex++
                }
                    if (questionIndex >= arrayList.size) {
                        showAnimationDialogBox()

                }
            }

            binding.falseCheckBox.setOnClickListener {
                binding.trueCheckBox.isChecked = false
            }
            binding.trueCheckBox.setOnClickListener {
                binding.falseCheckBox.isChecked = false
            }

        }

    private fun showAnimationDialogBox() {
      val alertDialog = AlertDialog.Builder(requireContext())
        val dialogView= layoutInflater.inflate(R.layout.animation_dialog_layout,null)
//        val lottie  = dialogView.findViewById<LottieAnimationView>(R.id.lottieAnimationView)
//        lottie.playAnimation()
        alertDialog.setView(dialogView)
        alertDialog.setPositiveButton("Next"){
            dialog,_->
            dialog.dismiss()
        }
        alertDialog.show()
    }

    }