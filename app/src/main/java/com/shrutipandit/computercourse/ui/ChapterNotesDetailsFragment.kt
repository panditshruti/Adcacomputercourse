package com.shrutipandit.computercourse.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.shrutipandit.computercourse.R
import com.shrutipandit.computercourse.adapter.NotesAdapter
import com.shrutipandit.computercourse.databinding.FragmentChapterNotesDetailsBinding
import com.shrutipandit.computercourse.list.NotesList

class ChapterNotesDetailsFragment : Fragment(R.layout.fragment_chapter_notes_details) {

    private lateinit var binding:FragmentChapterNotesDetailsBinding
    private lateinit var db : DatabaseReference
    private lateinit var arrayList: ArrayList<NotesList>
    private lateinit var notesAdapter: NotesAdapter
    private val args: ChapterNotesDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChapterNotesDetailsBinding.bind(view)

        val argumentString = args.chapterName
        db = FirebaseDatabase.getInstance().reference.child(argumentString)
        arrayList = arrayListOf()
        fetchNotes()

        notesAdapter = NotesAdapter(arrayList)
        binding.recyclerView.adapter = notesAdapter
        binding. recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun fetchNotes(){
        db.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (data in snapshot.children){
                        val question =  data.child("question").value as? String
                        val answer = data.child("answer").value as? String
                        val imgUri = data.child("imgurl").value as? String
                        if(question != null && answer != null && imgUri != null){
                            arrayList.add(NotesList(question,answer,imgUri))
                        }
                    }
                    notesAdapter.notifyDataSetChanged()
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }

        })
    }
}

