package com.javasampleapproach.requestmapping.model

data class Customer
(
                    var id: Long=0,
                    var nric: String="",
                    var firstName: String="",
                    var middleName: String="" ,
                    var lastName: String="" ,
                    var dateOfBirth: String="" ,
                    var policyID: String ="",
                    var policyAmount: Float=0.0f,
                    var policyExpiry: String ="",
                    var eLogActive: Boolean=false
)
/*{
    constructor() : this("", emptyList(),
            "", emptyList(), -1,
            "", "", hashMapOf<Any, Any>(),
            -1, LinkedTreeMap<Any, Any>()
    )
}
        */