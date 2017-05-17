package com.realtorsnepal.service.impl;

import com.realtorsnepal.dao.CustomerDao;
import com.realtorsnepal.model.Customer;
import com.realtorsnepal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Samima on 1/25/2017.
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer){
        customerDao.addCustomer(customer);
    }
    public void editCustomer(Customer customer){
        customerDao.editCustomer(customer);
    }

    public Customer getCustomerById(int customerId){
        return customerDao.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers(){
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername (String username){
        return customerDao.getCustomerByUsername(username);
    }
}
