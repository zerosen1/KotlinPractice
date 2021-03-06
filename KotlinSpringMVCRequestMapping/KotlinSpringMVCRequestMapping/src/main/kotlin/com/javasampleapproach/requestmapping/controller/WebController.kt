package com.javasampleapproach.requestmapping.controller

import com.javasampleapproach.requestmapping.model.Customer
import org.springframework.http.ResponseEntity
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

    @PostConstruct
    fun initial() {
        DatabaseConnection.setIP("127.0.0.1")
        DatabaseConnection.setPort("3306")
        DatabaseConnection.setDB("EMP")
        DatabaseConnection.SetCredentials("root", "123456")
        DatabaseConnection.OpenConnection()
    }

    @GetMapping("/")
    fun getAll(): MutableMap<Long, Customer> {
        return Query.resultset()
    }

    @PostMapping("/post")
    fun postCustomer(@RequestBody customer: Customer): Customer{
        return Query.Insert(customer)
    }

    @PutMapping("/put")
    fun putCustomer(@RequestBody customer: Customer): Customer {
        try {
               if (customer!=null) {
            return Query.Put(customer)
               } else {throw IllegalArgumentException("IPAddress Invalid: Please Check")}
        } catch (e: Exception) { return Query.Put(customer)}
    return Query.Put(customer)
    }

    @DeleteMapping("/delete")
    fun deleteMethod(@RequestBody customer: Customer): String {
        return Query.Delete(customer.nric)
    }

//    @GetMapping("/get")
//    fun getCustomer(@RequestParam("id") id: Long): Customer {
//        val cust = custStores.getValue(id);
//
//        return cust
//    }
//    @DeleteMapping("/delete")
//    fun deleteMethodX(@PathVariable id: Long): ResponseEntity<Unit> {
//        try {
         //   if (dogRepository.exists(id)) {
         //       dogRepository.delete(id)
//                return ResponseEntity.ok().build()
         //   } else {
           //     return ResponseEntity.notFound().build()
            //}
//        } catch (e: Exception) { return ResponseEntity.notFound().build() }
//    }
}
