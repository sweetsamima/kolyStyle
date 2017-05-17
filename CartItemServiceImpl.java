package com.realtorsnepal.service.impl;

import com.realtorsnepal.dao.CartItemDao;
import com.realtorsnepal.model.Cart;
import com.realtorsnepal.model.CartItem;
import com.realtorsnepal.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Samima on 1/26/2017.
 */
@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem){
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem){
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart){
        cartItemDao.removeAllCartItems(cart);
    }

    public CartItem getCartItemByProductId(int productId){
        return cartItemDao.getCartItemByProductId(productId);
    }
}
