package com.rockycamacho.diversify.test.presentation.exercises.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rockycamacho.diversify.test.data.network.models.Exercise
import kotlinx.android.synthetic.main.item_exercise.view.*

class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(exercise: Exercise, clickListener: (Exercise) -> Unit) {
        itemView.name.text = exercise.name
        Glide.with(itemView)
            .load(exercise.imageUrl)
            .into(itemView.image)
        itemView.description.text = exercise.description
        itemView.setOnClickListener { clickListener(exercise) }
    }
}