package com.example.localcoffeeshop.Utils

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.localcoffeeshop.Models.User

class DataAccess(context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null,  DATABASE_VER) {
    companion object {
        private val DATABASE_NAME = "SNHU.db"
        private val DATABASE_VER = 1


        // Table
        private val TABLE_NAME = "User"
        private val COL_ID = "Id"
        private val COL_USERNAME = "Username"
        private val COL_PASSWORD = "Password"
        private val COL_EMAIL = "Email"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY:String = ("CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY, $COL_USERNAME TEXT, $COL_EMAIL TEXT, $COL_PASSWORD TEXT)")
        db!!.execSQL(CREATE_TABLE_QUERY);
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    // CRUD operations
    val allUsers:List<User>
    get() {
        val users = ArrayList<User>()
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val user = User()

                    user.id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                    user.username = cursor.getString(cursor.getColumnIndex(COL_USERNAME))
                    user.password = cursor.getString(cursor.getColumnIndex(COL_PASSWORD))
                    user.email = cursor.getString(cursor.getColumnIndex(COL_EMAIL))
                users.add(user)
            } while (cursor.moveToNext())
        }
        db.close()
        return users
    }

    fun addUser(user: User){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL_ID, user.id)
        values.put(COL_EMAIL, user.email)
        values.put(COL_PASSWORD, user.password)
        values.put(COL_USERNAME, user.username)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun updateUser(user: User){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL_ID, user.id)
        values.put(COL_EMAIL, user.email)
        values.put(COL_PASSWORD, user.password)
        values.put(COL_USERNAME, user.username)
         db.update(TABLE_NAME, values, "$COL_ID=?", arrayOf(user.id.toString()))
        db.close()
    }
    fun deleteUser(user: User) {
        val db = this.writableDatabase

        db.delete(TABLE_NAME,"$COL_ID=?", arrayOf(user.id.toString()))
        db.close()
    }
}