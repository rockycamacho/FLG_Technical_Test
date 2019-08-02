package com.rockycamacho.diversify.test.presentation.exercises.view

import androidx.recyclerview.widget.DiffUtil
import com.rockycamacho.diversify.test.data.network.models.Muscle

class MuscleItemCallback : DiffUtil.ItemCallback<Muscle>() {
    override fun areItemsTheSame(oldItem: Muscle, newItem: Muscle): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Muscle, newItem: Muscle): Boolean {
        return oldItem.name == newItem.name
    }
}
