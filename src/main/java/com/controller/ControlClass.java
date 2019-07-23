package com.controller;

import com.controller.cashier.CashierController;
import com.domain.Cashier;
import com.service.Cashier.CashierServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
public class ControlClass {

    //@Autowired
    //CashierController cashier;
    @RequestMapping("/home")
    public String getPage()
    {
        //System.out.println("i'm here");
        return "home.jsp";
    }
    @RequestMapping(value = "/cashier")
    public ArrayList getCashierServicer()
    {
        System.out.println("in cashier");
        //return cashier.getAll();
        return null;
    }

   //@GetMapping("/home")
   @ResponseBody
    public String getHome()
    {
        return "hello home";
    }
}
