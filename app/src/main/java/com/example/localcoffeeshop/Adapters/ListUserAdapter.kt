package com.example.localcoffeeshop.Adapters

import android.app.Activity
import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import com.example.localcoffeeshop.Models.User
import com.example.localcoffeeshop.R
import kotlinx.android.synthetic.main.row_layout.view.*

class ListUserAdapter(internal  var activity: Activity,
                      internal var userList:List<User>,
                      internal var id:EditText,
                      internal var username:EditText,

                      internal var email:EditText): BaseAdapter() {

    internal var inflater: LayoutInflater

    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView:View
        rowView = inflater.inflate(R.layout.row_layout,null)

        rowView.txt_row_id.text = userList[position].id.toString()
        rowView.txt_email.text = userList[position].email.toString()
        rowView.txt_username.text = userList[position].username.toString()

        rowView.setOnClickListener {
            id.setText(rowView.txt_row_id.text.toString())
            email.setText(rowView.txt_email.text.toString())
            username.setText(rowView.txt_username.text.toString())
        }
        return rowView
    }

    override fun getItem(position: Int): Any {
        return userList[position]
    }

    override fun getItemId(position: Int): Long {
      return userList[position].id.toLong()
    }

    override fun getCount(): Int {
        return userList.size

    }


}