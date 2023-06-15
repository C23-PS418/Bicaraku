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
<<<<<<< HEAD
import com.projek.bicarakuu.MainActivity
=======
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
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

        abjadAdapter = AbjadAdapter(requireContext(), dataList)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
        recyclerView.adapter = abjadAdapter

<<<<<<< HEAD
        dataList.add(DataModel(R.drawable.icon_a, "A","https://storage.googleapis.com/bicaraku-storage/kamus/A/A_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_b,"B","https://storage.googleapis.com/bicaraku-storage/kamus/B/B_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_c,"C","https://storage.googleapis.com/bicaraku-storage/kamus/C/C_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_d,"D","https://storage.googleapis.com/bicaraku-storage/kamus/D/D_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_e,"E","https://storage.googleapis.com/bicaraku-storage/kamus/E/E_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_f,"F","https://storage.googleapis.com/bicaraku-storage/kamus/F/F_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_g,"G","https://storage.googleapis.com/bicaraku-storage/kamus/G/G%20(15).jpg"))
        dataList.add(DataModel(R.drawable.icon_h,"H","https://storage.googleapis.com/bicaraku-storage/kamus/H/H_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_i,"I","https://storage.googleapis.com/bicaraku-storage/kamus/I/I_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_j,"J","https://storage.googleapis.com/bicaraku-storage/kamus/J/J_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_k,"K","https://storage.googleapis.com/bicaraku-storage/kamus/K/K_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_l,"L","https://storage.googleapis.com/bicaraku-storage/kamus/L/L_4.jpg"))
        dataList.add(DataModel(R.drawable.icon_m,"M","https://storage.googleapis.com/bicaraku-storage/kamus/M/M_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_n,"N","https://storage.googleapis.com/bicaraku-storage/kamus/N/N_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_o,"O","https://storage.googleapis.com/bicaraku-storage/kamus/O/O_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_p,"P","https://storage.googleapis.com/bicaraku-storage/kamus/P/P_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_q,"Q","https://storage.googleapis.com/bicaraku-storage/kamus/Q/Q_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_r,"R","https://storage.googleapis.com/bicaraku-storage/kamus/R/R_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_s,"S","https://storage.googleapis.com/bicaraku-storage/kamus/S/S_01.jpg"))
        dataList.add(DataModel(R.drawable.icon_t,"T","https://storage.googleapis.com/bicaraku-storage/kamus/T/T_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_u,"U","https://storage.googleapis.com/bicaraku-storage/kamus/U/U_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_v,"V","https://storage.googleapis.com/bicaraku-storage/kamus/V/V_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_w,"W","https://storage.googleapis.com/bicaraku-storage/kamus/W/W_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_x,"X","https://storage.googleapis.com/bicaraku-storage/kamus/X/X_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_y,"Y","https://storage.googleapis.com/bicaraku-storage/kamus/Y/Y_1.jpg"))
        dataList.add(DataModel(R.drawable.icon_z,"Z","https://storage.googleapis.com/bicaraku-storage/kamus/Z/Z_6.jpg"))
=======
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
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
        abjadAdapter.notifyDataSetChanged()
        return view
    }
}
