package com.realtorsnepal.dao.impl;

import com.realtorsnepal.dao.SavedPaymentDao;
import com.realtorsnepal.model.Customer;
import com.realtorsnepal.model.SavedPayment;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Created by Samima on 4/29/2017.
 */
@Repository
@Transactional
public class SavedPaymentDaoImpl implements SavedPaymentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SavedPayment getCardById(int id){
        Session session = sessionFactory.getCurrentSession();
        SavedPayment savedPayment = (SavedPayment) session.get(SavedPayment.class,id);
        session.flush();

        return savedPayment;
    }

    public List<SavedPayment> getCardsList(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from SavedPayment");
        List<SavedPayment> cardsList = query.list();
        session.flush();

        return cardsList;
    }

    public void addCard(SavedPayment savedPayment){
        Session session = sessionFactory.getCurrentSession();
        savedPayment.getBillingAddress().setSavedPayment(savedPayment);
        savedPayment.getCustomer().setSavedPayment(savedPayment);

        session.saveOrUpdate(savedPayment);
        session.saveOrUpdate(savedPayment.getBillingAddress());
        session.saveOrUpdate(savedPayment.getCustomer());
        session.flush();
    }

    public void editCard(SavedPayment savedPayment){
        Session session = sessionFactory.getCurrentSession();
        savedPayment.getBillingAddress().setSavedPayment(savedPayment);
        savedPayment.getCustomer().setSavedPayment(savedPayment);

        session.saveOrUpdate(savedPayment);
        session.saveOrUpdate(savedPayment.getBillingAddress());
        session.saveOrUpdate(savedPayment.getCustomer());
        session.flush();
    }

    public void deleteCard(SavedPayment savedPayment){
        Session session = sessionFactory.getCurrentSession();
        session.delete(savedPayment);
        session.flush();
    }

    public List<SavedPayment> getAllCustomerSavedPayment(Customer customer){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from SavedPayment where customer = ?");
        List<SavedPayment> savedPaymentList = query.list();

        return savedPaymentList;
    }
}
