package com.javasampleapproach.requestmapping.model

data class Customer(
		var id: Long = -1,
		var firstName: String = "",
		var lastName: String = "",
		var age: Int = -1) {
}