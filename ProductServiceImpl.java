package com.realtorsnepal.service.impl;

import com.realtorsnepal.dao.ProductDao;
import com.realtorsnepal.model.Product;
import com.realtorsnepal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Samima on 1/22/2017.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public Product getProductById(int productId){
        return productDao.getProductById(productId);
    }

    public List<Product> getProductList(){
        return productDao.getProductList();
    }

    public void addProduct(Product product){
        productDao.addProduct(product);
    }

    public void editProduct(Product product){
        productDao.editProduct(product);
    }

    public void deleteProduct(Product product){
        productDao.deleteProduct(product);
    }
}
