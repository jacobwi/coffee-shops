package com.example.localcoffeeshop.Models

class User {
    var id:Int = 0
    var username:String?=null
    var email:String?=null
    var password:String?=null

    constructor() {}
    constructor(id: Int, username: String?, email: String?, password: String?) {
        this.id = id
        this.username = username
        this.email = email
        this.password = password
    }
}