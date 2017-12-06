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

@RestController
@RequestMapping(value="/api/customer")
class WebController {
	// Define a customer storage
	val custStores = mutableMapOf<Long, Customer>()
	
	@PostConstruct
    fun initial(){
        custStores.put(1, Customer(1, "Jack", "Smith", 20))
        custStores.put(2, Customer(2, "Peter", "Johnson", 25))
    }
	
	@GetMapping("/")
    fun getAll(): MutableMap<Long, Customer>{
		println("########### GET All Customers: ${custStores}")
		return custStores
    }
	
	@GetMapping("/get")
    fun getCustomer(@RequestParam("id") id: Long): Customer{
		val cust = custStores.getValue(id);
		println("########### GET a Customers with ${cust}")
		return cust
    }
 
    @PostMapping("/post")
    fun postCustomer(@RequestBody customer: Customer): String{
		// do post
		custStores.put(customer.id, customer)
		
		// log on console
		println("########### POST:" + customer)
		
        return "Post Sucessfully!"
    }
 
    @PutMapping("/put/{id}")
    fun putCustomer(@PathVariable id: Long, @RequestBody customer: Customer): String{
		// reset customer.Id
		customer.id = id;
		
		if(custStores.get(id) != null){
			custStores.replace(id, customer)
		}else{
			customer.id = id
			custStores.put(id, customer)
		}
		
		println("########### PUT:" + customer)
		return "Put Sucessfully!"
    }
 
    @DeleteMapping("/delete/{id}")
    fun deleteMethod(@PathVariable id: Long): String {
		val cust = custStores.remove(id)
		if(cust != null){
			println("########### DELETE:" + cust)
		}else{
			println("########### Don't exist any customer with id = ${id}")
		}
		
		return "Done!"
    }
}