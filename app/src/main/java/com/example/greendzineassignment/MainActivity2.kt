package com.example.greendzineassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.greendzineassignment.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

  //  RecyclerView recyclerView;

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())


        binding.BottomNavigationView.setOnNavigationItemSelectedListener  {
            when(it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.employees -> replaceFragment(EmployeeFragment())

                else -> {

                }
            }
            true
        }


    }

    private fun replaceFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.FrameLayout, fragment)
            commit()

        }
}