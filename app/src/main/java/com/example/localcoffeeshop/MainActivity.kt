package com.example.localcoffeeshop

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.example.localcoffeeshop.Adapters.ListUserAdapter
import com.example.localcoffeeshop.Models.Order
import com.example.localcoffeeshop.Models.User
import com.example.localcoffeeshop.Utils.DataAccess
import com.example.localcoffeeshop.Utils.SharedPrefsLocally
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {
    internal lateinit var db:DataAccess
    internal var userList: List<User> = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create classes instances
        var location = Location()
        var orders = Order()
        var items = Items()
        var profile = Profile()


        // Set default tab
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, Location())
            .commit()

        // Listener for the bottom navigation menu
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.location -> handleFragments(location)

            }

            return@setOnNavigationItemSelectedListener true
        }

    }

    // Dynamic Implementation of fragment transition
    private fun handleFragments(fragment: Fragment) {
        val fragTran = supportFragmentManager.beginTransaction()
        fragTran.replace(R.id.frame_layout, fragment)
        fragTran.commit()
    }


}
