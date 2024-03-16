package com.example.greendzineassignment

import EmployeeAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonArray
import java.util.Locale
import com.example.greendzineassignment.DataClass as DataClass
import androidx.appcompat.widget.SearchView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EmployeeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EmployeeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView;
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var searchView = view.findViewById(R.id.searchView) as androidx.appcompat.widget.SearchView


        recyclerView = view.findViewById(R.id.recyclerView)

//        val includeLayout = view.findViewById<View>(R.id.include_layout)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        val dataClass1 = DataClass(
            1,
            "Arjun",
            "16-11-2000",
            "Software Engineer")
        val dataClass2 = DataClass(
            2,
            "Mahesh",
            "15-01-2000",
            "Web Developer"
        )
        val dataClass3 = DataClass(
            3,
            "Rajesh",
            "04-08-2004",
            "Mobile Developer"
        )
        val dataClass4 = DataClass(
            4,
            "Raja",
            "11-11-2003",
            "Web Developer"
        )
        val dataClass5 = DataClass(
            5, "Gokul",
            "13-09-2001",
            "Mobile Developer"
        )
        val dataClass6 = DataClass(
            6,
            "Hema",
            "16-08-2002",
            "Software Engineer"
        )
        val list = ArrayList<DataClass>()
        list.add(dataClass1)
        list.add(dataClass2)
        list.add(dataClass3)
        list.add(dataClass4)
        list.add(dataClass5)
        list.add(dataClass6)

        var obj = DataClassList(list)

        var adapter = EmployeeAdapter(obj.employees)
        recyclerView.adapter = adapter
//        includeLayout.visibility = View.VISIBLE
        recyclerView.visibility = View.VISIBLE

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText, list, adapter)
                return true
            }
        })



    }



    private fun filterList(query: String?, list: ArrayList<DataClass>, adapter: EmployeeAdapter) {
        if (query.isNullOrEmpty()) {
            // Reset the adapter with the original list
            adapter.setFilteredList(list)
        } else {
            val filteredList = ArrayList<DataClass>()

            for (i in list) {
                if (i.name.lowercase(Locale.ROOT).contains(query.lowercase(Locale.ROOT))) {

                    filteredList.add(i)
                }
            }
            Log.d("Filtered List",filteredList.toString())
            if (filteredList.isEmpty()) {
                adapter.setFilteredList(filteredList)
                Toast.makeText(requireContext(), "No Data Found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EmployeeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EmployeeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

