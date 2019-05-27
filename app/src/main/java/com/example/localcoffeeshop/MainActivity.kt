package com.example.localcoffeeshop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.localcoffeeshop.Adapters.ListUserAdapter
import com.example.localcoffeeshop.Models.User
import com.example.localcoffeeshop.Utils.DataAccess
import com.example.localcoffeeshop.Utils.SharedPrefsLocally

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    internal lateinit var db:DataAccess
    internal var userList: List<User> = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myPref = SharedPrefsLocally(this)
        var logCount = myPref.getLogCount()
        db = DataAccess(this)
        refreshData()

        add_btn.setOnClickListener {
            val user = User(
                Integer.parseInt(id.text.toString()),
                username.text.toString(),
                password.text.toString(),
                email.text.toString()

            )
            db.addUser(user)
            logCount++;
            titleName.text = ("Saved Locally $logCount")
            refreshData()
        }
        edit_btn.setOnClickListener{
            val user = User(
                Integer.parseInt(id.text.toString()),
                username.text.toString(),
                password.text.toString(),
                email.text.toString()

            )
            logCount++;
            titleName.text = ("Saved Locally $logCount")
            db.updateUser(user)
            refreshData()
        }

        delete_btn.setOnClickListener{
            val user = User(
                Integer.parseInt(id.text.toString()),
                username.text.toString(),
                password.text.toString(),
                email.text.toString()

            )
            logCount++;
            titleName.text = ("Saved Locally $logCount")
            db.deleteUser(user)
            refreshData()
        }
    }


    private fun refreshData() {
        userList = db.allUsers
        val adapter = ListUserAdapter(this, userList, id, username, email)
        user_list.adapter = adapter
    }


}
