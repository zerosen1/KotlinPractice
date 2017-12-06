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

    // Define a customer storage

    @PostConstruct
    fun initial() {
        DatabaseConnection.setIP("127.0.0.1")
        DatabaseConnection.setPort("3306")
        DatabaseConnection.setDB("EMP")
        DatabaseConnection.SetCredentials("root", "1234")
        DatabaseConnection.OpenConnection()
    }

    @GetMapping("/")
    fun getAll(): MutableMap<Long, Customer> {
        return Query.resultset()
    }

//    @GetMapping("/get")
//    fun getCustomer(@RequestParam("id") id: Long): Customer {
//        val cust = custStores.getValue(id);
//
//        return cust
//    }

    @PostMapping("/post")
    fun postCustomer(@RequestBody customer: Customer): String{

        var x = customer.toString()
        Query.Insert(x)
        return x
    }

    @PutMapping("/put/{id}")
    fun putCustomer(@RequestBody customer: Customer): Customer {


        return Query.Put(customer)
    }

    @DeleteMapping("/delete")
    fun deleteMethod(@PathVariable id: Long): String
    {

        return "haha"

    }


//    @DeleteMapping("/delete")
//    fun deleteMethodX(@PathVariable id: Long): ResponseEntity<Unit> {
//        try {
//         //   if (dogRepository.exists(id)) {
//         //       dogRepository.delete(id)
//                return ResponseEntity.ok().build()
//         //   } else {
//           //     return ResponseEntity.notFound().build()
//            //}
//        } catch (e: Exception) { return ResponseEntity.notFound().build() }
//    }
}
