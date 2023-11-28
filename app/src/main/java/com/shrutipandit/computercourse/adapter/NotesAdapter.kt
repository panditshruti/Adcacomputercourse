package com.shrutipandit.computercourse.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shrutipandit.computercourse.R
import com.shrutipandit.computercourse.list.NotesList
import com.squareup.picasso.Picasso
import java.util.ArrayList


class NotesAdapter  (private val arrayList: ArrayList<NotesList>): RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val question: TextView =itemView.findViewById(R.id.question)
        val answer: TextView =itemView.findViewById(R.id.answer)
        val notesImageView: ImageView =itemView.findViewById(R.id.notesImageView)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sample_notes_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notes = arrayList[position]

        if(notes.question == " "){
            holder.question.visibility = View.GONE
        }else{
            holder.question.text = notes.question
        }
        if (notes.imageUri == " "){
            holder.notesImageView.visibility = View.GONE
        }else{
            Picasso.get().load(notes.imageUri).into(holder.notesImageView)
        }


        holder.answer.text = notes.answer
    }

}


