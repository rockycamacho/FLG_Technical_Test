package com.rockycamacho.diversify.test.presentation.exercises.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.rockycamacho.diversify.test.R
import com.rockycamacho.diversify.test.data.network.models.Muscle

class MuscleListAdapter() :
    ListAdapter<Muscle, MuscleViewHolder>(MuscleItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuscleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MuscleViewHolder(inflater.inflate(R.layout.item_muscle, parent, false))
    }

    override fun onBindViewHolder(holder: MuscleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
