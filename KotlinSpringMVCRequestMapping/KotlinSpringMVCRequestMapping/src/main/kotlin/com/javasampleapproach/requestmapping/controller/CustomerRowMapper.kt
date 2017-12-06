package com.javasampleapproach.requestmapping.controller

import com.javasampleapproach.requestmapping.model.Customer
import java.sql.ResultSet

import org.springframework.jdbc.core.RowMapper;

class CustomerRowMapper : RowMapper<Customer> {


    override public fun  mapRow(rs : ResultSet, rowNum: Int ) : Customer {

        val customer = Customer()
        customer.firstName = rs.getString("firstName")
        customer.lastName = rs.getString("lastName")
        customer.middleName = rs.getString("middleName")
        customer.dateOfBirth = rs.getString("dateOfBirth")
        customer.eLogActive = rs.getInt("eLogActive")
        customer.nric = rs.getString("nric")
        customer.id = rs.getLong("id")
        customer.policyID = rs.getString("policyID")
        customer.policyAmount = rs.getFloat("policyAmount")
        customer.policyExpiry = rs.getString("policyExpiry")

        return customer
    }

}

