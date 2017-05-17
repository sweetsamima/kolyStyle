package com.realtorsnepal.service.impl;

import com.realtorsnepal.dao.CartDao;
import com.realtorsnepal.model.Cart;
import com.realtorsnepal.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Samima on 1/26/2017.
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    public Cart getCartById(int cartId){
        return cartDao.getCartById(cartId);
    }

    public void update(Cart cart){
        cartDao.update(cart);
    }
}
