package com.example.buecherei2_0.controller;

import com.example.buecherei2_0.entity.Customer;
import com.example.buecherei2_0.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository cRepo;

    @GetMapping("/showCustomer")
    public ModelAndView showCustomer(){
        ModelAndView mav = new ModelAndView("list-customer");
        List<Customer> list = cRepo.findAll();
        mav.addObject("customer", list);
        return mav;
    }

    @GetMapping("/addCustomer")
    public ModelAndView addCustomerForm(){
        ModelAndView mav = new ModelAndView("add-customer-form");
        Customer newCustomer = new Customer();
        mav.addObject("cusomer", newCustomer);
        return mav;
    }

    @GetMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer){
        cRepo.save(customer);
        return "redirect:/showCustomer";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long customerId){
        ModelAndView mav = new ModelAndView("add-customer-form");
        Customer customer = cRepo.findById(customerId),get();
        mav.addObject("customer", customer);
        return mav;
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam Long customerId){
        cRepo.deleteById(customerId);
        return "redirect:/showCustomer";
    }
}










