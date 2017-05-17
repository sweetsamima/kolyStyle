package com.realtorsnepal.service.impl;

import com.realtorsnepal.dao.PromoCodesDao;
import com.realtorsnepal.model.Cart;
import com.realtorsnepal.model.PromoCodes;
import com.realtorsnepal.service.PromoCodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Samima on 5/14/2017.
 */
@Service
public class PromoCodesServiceImpl implements PromoCodesService{
    @Autowired
    private PromoCodesDao promoCodesDao;

    public void addPromoCode(PromoCodes promoCodes){
        promoCodesDao.addPromoCode(promoCodes);
    }

    public void removePromoCode(PromoCodes promoCodes){
        promoCodesDao.removePromoCode(promoCodes);
    }

    public PromoCodes getPromoCodeById(int promoCodeId){
        return promoCodesDao.getPromoCodeById(promoCodeId);
    }
    public List<PromoCodes> getAllPromoCodes(){
        return promoCodesDao.getAllPromoCodes();
    }
    public PromoCodes getPromoCodeByCode(String promoCode){return promoCodesDao.getPromoCodeByCode(promoCode);}
    public void update(Cart cart, String promocode){
        promoCodesDao.update(cart, promocode);
    }
}
