package com.javasampleapproach.requestmapping.controller

import com.javasampleapproach.requestmapping.model.Customer
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct
var storage1 = mutableMapOf<Long, Customer>()
@RestController
@RequestMapping(value="/api/customer")
class WebController {
    // Define a customer storage
    val custStores = mutableMapOf<Long, Customer>()

    @PostConstruct
    fun initial ()
    {
    }

    @GetMapping("/")
    fun getAll(): MutableMap <Long, Customer>
    {
        DatabaseConnection.setIP("127.0.0.1")
        DatabaseConnection.setPort("3306")
        DatabaseConnection.setDB("EMP")
        DatabaseConnection.SetCredentials("root" ,"123456")
        DatabaseConnection.OpenConnection()
        Query.resultset()
        DatabaseConnection.CloseConnection()
        return storage1
    }

    @GetMapping("/get")
    fun getCustomer(@RequestParam("id") id: Long): Customer
    {

        val cust = custStores.getValue(id);
        return cust
    }

    @PostMapping("/post")
    fun postCustomer(@RequestBody customer: Customer): Customer?
    {
        DatabaseConnection.setIP("127.0.0.1")
        DatabaseConnection.setPort("3306")
        DatabaseConnection.setDB("EMP")
        DatabaseConnection.SetCredentials("root" ,"123456")
		var x="("+"'"+customer.nric+"'"+"," + "'"+customer.firstName+"'"+","+"'"+customer.middleName+"'"+","+"'"+customer.lastName+"'"+","+"'"+customer.dateOfBirth+"'"+","+"'"+customer.policyID+"'"+","+"'"+customer.policyAmount+"'"+","+"'"+customer.policyExpiry+"'"+","+"'"+customer.eLogActive+"'"+")"
    DatabaseConnection.OpenConnection()
    Query.Insert(x)
	DatabaseConnection.CloseConnection()
        println("insertdone")

        return custStores.put(customer.id, customer)

    }

    @PutMapping("/put/{id}")
    fun putCustomer(@PathVariable id: Long, @RequestBody customer: Customer): String
    {
        // reset customer.Id
        customer.id = id;

        if(custStores.get(id) != null)
        {
            custStores.replace(id, customer)
        }
        else
        {
            customer.id = id
            custStores.put(id, customer)
        }
        return "Put Sucessfully!"
    }

    @DeleteMapping("/delete/{id}")
    fun deleteMethod(@PathVariable id: Long): String
    {
        return "Done!"
    }
}
