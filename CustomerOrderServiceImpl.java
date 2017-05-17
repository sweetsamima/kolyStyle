package com.realtorsnepal.service.impl;

import com.realtorsnepal.dao.CustomerOrderDao;
import com.realtorsnepal.model.Cart;
import com.realtorsnepal.model.CartItem;
import com.realtorsnepal.model.CustomerOrder;
import com.realtorsnepal.service.CartService;
import com.realtorsnepal.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Samima on 1/27/2017.
 */
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder){
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(int cartId){
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for(CartItem item : cartItems){
            grandTotal += item.getTotalPrice();
        }
        return grandTotal;
    }
}
