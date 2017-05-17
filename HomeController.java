package com.realtorsnepal.controller;

import com.realtorsnepal.model.Product;
import com.realtorsnepal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Samima on 1/22/2017.
 */
@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String home(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
      //  model.addAttribute("searchCondition", searchCondition);
        return "index";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout",
            required = false) String logout, Model model){
        if(error != null){
            model.addAttribute("error", "Invalid Username and Password");
        }

        if(logout != null){
            model.addAttribute("msg","You have been logged out successfully.");
        }

        return "login";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
