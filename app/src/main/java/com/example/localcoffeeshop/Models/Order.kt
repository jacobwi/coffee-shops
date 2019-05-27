package com.example.localcoffeeshop.Models

import java.util.*
import kotlin.collections.ArrayList

class Order {
    var items:ArrayList<MenuItem>?=null
    var submissionDate: Date?=null
    var completionDate: Date?=null
    var user: User?=null
    var payment: Card?=null
    var store: Store?=null



}