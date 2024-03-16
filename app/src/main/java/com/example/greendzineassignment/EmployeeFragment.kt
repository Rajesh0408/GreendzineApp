package com.example.greendzineassignment

import EmployeeAdapter
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.SearchView.OnQueryTextListener
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonArray
import java.util.Locale
import com.example.greendzineassignment.DataClass as DataClass
import androidx.appcompat.widget.SearchView
import com.google.gson.Gson
import java.io.File


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


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

        return inflater.inflate(R.layout.fragment_employee, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var searchView = view.findViewById(R.id.searchView) as androidx.appcompat.widget.SearchView

        var search = view.findViewById(R.id.searchView) as SearchView
        var searchEditText =  search.findViewById(androidx.appcompat.R.id.search_src_text) as (EditText)
        searchEditText.setTextColor(getResources().getColor(R.color.white));
        searchEditText.setHintTextColor(getResources().getColor(R.color.white));
        searchEditText.setBackgroundColor(Color.TRANSPARENT);

        recyclerView = view.findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        val assetManager = requireContext().assets
        val inputStream = assetManager.open("jsonClass.json")
        val jsonString = inputStream.bufferedReader().use { it.readText() }



        val dataClassList = Gson().fromJson(jsonString, DataClassList::class.java)


        val employees = dataClassList.employees

        var adapter = EmployeeAdapter(employees)
        recyclerView.adapter = adapter
        recyclerView.visibility = View.VISIBLE

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText, employees, adapter)
                return true
            }
        })



    }



    private fun filterList(query: String?, list: ArrayList<DataClass>, adapter: EmployeeAdapter) {
        if (query.isNullOrEmpty()) {

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

