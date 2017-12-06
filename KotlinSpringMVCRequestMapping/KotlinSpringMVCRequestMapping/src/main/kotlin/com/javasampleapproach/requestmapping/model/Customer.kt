package com.javasampleapproach.requestmapping.model

data class Customer(

		var id: Long=0,
		var nric: String="",
		var firstName: String="",
		var middleName: String="" ,
		var lastName: String="" ,
		var dateOfBirth: String="" ,
		var policyID: String ="",
		var policyAmount: Float=0.0f,
		var policyExpiry: String ="",
		var eLogActive: Int=0

){
    override fun toString(): String = "("+"'"+nric+"'"+"," + "'"+firstName+"'"+","+"'"+middleName+"'"+","+"'"+lastName+"'"+","+"'"+dateOfBirth+"'"+","+"'"+policyID+"'"+","+"'"+policyAmount+"'"+","+"'"+policyExpiry+"'"+","+"'"+eLogActive+"'"+")"
}