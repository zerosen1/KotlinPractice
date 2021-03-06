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
DatabaseConnection.setIP("127.0.0.1")
DatabaseConnection.setPort("3306")
DatabaseConnection.setDB("EMP")
DatabaseConnection.SetCredentials("root" ,"123456")
@RestController
@RequestMapping(value="/api/customer")
class WebController {
	// Define a customer storage
	val custStores = mutableMapOf<Long, Customer>()
	
	@PostConstruct
    fun initial()
    {
		custStores.put(1, Customer(1,"S1234567J","Darren","nil","Koh","10 Feb 1993","123",100.0F,"11 Feb 2017",true))
		custStores.put(2, Customer(2,"S1234567J","Kenji","nil","Sato","11 Feb 1993","1234",102.0F,"12 Feb 2017",false))

	}
	
	@GetMapping("/")
    fun getAll(): MutableMap<Long, Customer>
    {
		return custStores
    }
	
	@GetMapping("/get")
    fun getCustomer(@RequestParam("id") id: Long): Customer
    {
		val cust = custStores.getValue(id);
		return cust
    }
 
    @PostMapping("/post")
    fun postCustomer(@RequestBody customer: Customer): String
    {
		// do post
		custStores.put(customer.id, customer)
        DatabaseConnection.OpenConnection()
        Query.Insert()
        DatabaseConnection.CloseConnection()

        return "Post Sucessfully!"
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