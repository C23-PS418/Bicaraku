package com.projek.bicarakuu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.projek.bicarakuu.R
import com.projek.bicarakuu.adapter.AbjadAdapter
import com.projek.bicarakuu.data.DataModel


class ListAbjad : Fragment() {

    private lateinit var abjadAdapter: AbjadAdapter
    private var dataList = mutableListOf<DataModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_abjad, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        abjadAdapter = AbjadAdapter(requireContext(), dataList)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
        recyclerView.adapter = abjadAdapter

        dataList.add(DataModel(R.drawable.logo_b))
        dataList.add(DataModel(R.drawable.logo_b))
        dataList.add(DataModel(R.drawable.logo_b))
        dataList.add(DataModel(R.drawable.logo_b))
        dataList.add(DataModel(R.drawable.logo_b))
        dataList.add(DataModel(R.drawable.logo_b))



        abjadAdapter.notifyDataSetChanged()

        return view
    }

}