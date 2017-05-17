package com.realtorsnepal.service.impl;

import com.realtorsnepal.dao.SavedPaymentDao;
import com.realtorsnepal.model.Customer;
import com.realtorsnepal.model.SavedPayment;
import com.realtorsnepal.service.SavedPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by Samima on 4/29/2017.
 */
@Service
public class SavedPaymentServiceImpl implements SavedPaymentService {


    @Autowired
    private SavedPaymentDao savedPaymentDao;

    public SavedPayment getCardById(int savedPaymentId){
        return savedPaymentDao.getCardById(savedPaymentId);
    }

    @Override
    public List<SavedPayment> getAllCustomerSavedPayment(Customer customer) {
        return savedPaymentDao.getAllCustomerSavedPayment(customer);
    }

    public List<SavedPayment> getCardsList(){
        return savedPaymentDao.getCardsList();
    }

    public void addCard(SavedPayment savedPayment){
        savedPaymentDao.addCard(savedPayment);
    }

    public void editCard(SavedPayment savedPayment){
        savedPaymentDao.editCard(savedPayment);
    }

    public void deleteCard(SavedPayment savedPayment){
        savedPaymentDao.deleteCard(savedPayment);
    }
}
