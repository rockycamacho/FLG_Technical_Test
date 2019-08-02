package com.rockycamacho.diversify.test.presentation.exercises.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rockycamacho.diversify.test.data.network.models.Muscle
import kotlinx.android.synthetic.main.item_exercise.view.*

class MuscleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(muscle: Muscle) {
        itemView.name.text = muscle.name
        itemView.description.text = muscle.description
    }
}