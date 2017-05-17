package com.realtorsnepal.controller;

import com.realtorsnepal.model.Product;
import com.realtorsnepal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by Samima on 1/22/2017.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList/all")
    public String getProducts(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productList";
    }


    @RequestMapping("viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) throws IOException{
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);

        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "viewProduct";
    }

    @RequestMapping("/productList")
    public String getProductByCategory(@RequestParam("searchCondition") String searchCondition, Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        model.addAttribute("searchCondition", searchCondition);

        return "productList";
    }

    @ResponseBody
    public List<Product> getProducts( ){
        return productService.getProductList();
    }
    @RequestMapping("/{filters}")
    public @ResponseBody
    List<Product> getProductByFilters(@PathVariable(value = "filters") int cartId){
        return productService.getProductList();
    }

}
