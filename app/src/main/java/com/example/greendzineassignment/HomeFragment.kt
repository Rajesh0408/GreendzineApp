package com.example.greendzineassignment

import HomeAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView: RecyclerView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewProgress)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        val data1 = DataForProgress(
            "Productivity on Monday",
            "4%",
            4,
        )
        val data2 = DataForProgress(
            "Productivity on Tuesday",
            "92%",
            92,
        )
        val data3 = DataForProgress(
            "Productivity on Wednesday",
            "122%",
            122,
        )
        val data4 = DataForProgress(
            "Productivity on Thursday",
            "93%",
            93,
        )
        val data5 = DataForProgress(
            "Productivity on Friday",
            "89%", 89,
        )
        val data6 = DataForProgress(
            "Productivity on Saturday",
            "98%",
            98,
        )
//        val progress1 = view.findViewById<ProgressBar>(R.id.progress)
        val list = ArrayList<DataForProgress>()
        list.add(data1)
        list.add(data2)
        list.add(data3)
        list.add(data4)
        list.add(data5)
        list.add(data6)

        val obj = DataForProgressList(list)
        val adapter = HomeAdapter(obj.ProgressList)
        recyclerView.adapter = adapter
//        includeLayout.visibility = View.VISIBLE
        recyclerView.visibility = View.VISIBLE

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}