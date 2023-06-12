package com.projek.bicarakuu.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.projek.bicarakuu.AbjadDetailActivity
import com.projek.bicarakuu.R
import com.projek.bicarakuu.adapter.AbjadAdapter
import com.projek.bicarakuu.data.DataModel
import com.projek.bicarakuu.databinding.FragmentListAbjadBinding


class ListAbjad : Fragment() {

    private lateinit var binding: FragmentListAbjadBinding
    private lateinit var abjadAdapter: AbjadAdapter
    private var dataList = mutableListOf<DataModel>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListAbjadBinding.inflate(inflater, container, false)
        val view = binding.root

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        abjadAdapter = AbjadAdapter(requireContext(), dataList, object : AbjadAdapter.AbjadItemClickListener {
            override fun onItemClick(dataModel: DataModel) {
                val intent = Intent(requireContext(), AbjadDetailActivity::class.java)
                intent.putExtra("data", dataModel as Parcelable)
                startActivity(intent)
            }
        })
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
        recyclerView.adapter = abjadAdapter

        dataList.add(DataModel(R.drawable.ic_a))
        dataList.add(DataModel(R.drawable.ic_b))
        dataList.add(DataModel(R.drawable.ic_c))
        dataList.add(DataModel(R.drawable.ic_d))
        dataList.add(DataModel(R.drawable.ic_e))
        dataList.add(DataModel(R.drawable.ic_f))
        dataList.add(DataModel(R.drawable.ic_g))
        dataList.add(DataModel(R.drawable.ic_h))
        dataList.add(DataModel(R.drawable.ic_i))
        dataList.add(DataModel(R.drawable.ic_j))
        dataList.add(DataModel(R.drawable.ic_k))
        dataList.add(DataModel(R.drawable.ic_l))
        dataList.add(DataModel(R.drawable.ic_m))
        dataList.add(DataModel(R.drawable.ic_n))
        dataList.add(DataModel(R.drawable.ic_o))
        dataList.add(DataModel(R.drawable.ic_p))
        dataList.add(DataModel(R.drawable.ic_q))
        dataList.add(DataModel(R.drawable.ic_r))
        dataList.add(DataModel(R.drawable.ic_s))
        dataList.add(DataModel(R.drawable.ic_t))
        dataList.add(DataModel(R.drawable.ic_u))
        dataList.add(DataModel(R.drawable.ic_v))
        dataList.add(DataModel(R.drawable.ic_w))
        dataList.add(DataModel(R.drawable.ic_x))
        dataList.add(DataModel(R.drawable.ic_y))
        dataList.add(DataModel(R.drawable.ic_z))
        abjadAdapter.notifyDataSetChanged()
        return view
    }
}