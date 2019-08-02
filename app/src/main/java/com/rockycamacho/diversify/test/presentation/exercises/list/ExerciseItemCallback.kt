package com.rockycamacho.diversify.test.presentation.exercises.list

import androidx.recyclerview.widget.DiffUtil
import com.rockycamacho.diversify.test.data.network.models.Exercise

class ExerciseItemCallback: DiffUtil.ItemCallback<Exercise>() {
    override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
        return oldItem.name == newItem.name
    }
}
