package com.realtorsnepal.dao.impl;

import com.realtorsnepal.dao.PromoCodesDao;
import com.realtorsnepal.model.Cart;
import com.realtorsnepal.model.PromoCodes;
import com.realtorsnepal.service.CustomerOrderService;
import com.realtorsnepal.service.PromoCodesService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * Created by Samima on 5/14/2017.
 */
@Repository
@Transactional
public class PromoCodesDaoImpl implements PromoCodesDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CustomerOrderService customerOrderService;
    @Autowired
    private PromoCodesService promoCodesService;

    public void addPromoCode(PromoCodes promoCodes){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(promoCodes);
        session.flush();
    }

    public void removePromoCode(PromoCodes promoCodes){
        Session session = sessionFactory.getCurrentSession();
        session.delete(promoCodes);
        session.flush();
    }

    public List<PromoCodes> getAllPromoCodes(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from PromoCodes");
        List<PromoCodes> promoCodesList = query.list();

        return promoCodesList;
    }

    public void update(Cart cart, String promocode){
        int cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        PromoCodes promoCodes = promoCodesService.getPromoCodeByCode(promocode);
        int promo = promoCodes.getPromoPercent();
    //    double NewgrandTotal = grandTotal - ((promo/100)*grandTotal);
        double NewgrandTotal = grandTotal - 200;
        cart.setGrandTotal(NewgrandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
   }

    public PromoCodes getPromoCodeById(int promoCodeId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from PromoCodes where promoCodeId = ?");
        query.setInteger(0, promoCodeId);
        session.flush();

        return (PromoCodes) query.uniqueResult();
    }

    public PromoCodes getPromoCodeByCode(String promoCode){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from PromoCodes where promoCode = ?");
        query.setString(0, promoCode);
        session.flush();

        return (PromoCodes) query.uniqueResult();
    }
}
