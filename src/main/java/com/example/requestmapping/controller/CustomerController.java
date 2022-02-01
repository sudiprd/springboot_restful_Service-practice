package com.example.requestmapping.controller;


import com.example.requestmapping.service.Customer;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping(value = "customer")
@ResponseBody
public class CustomerController {


    @GetMapping(value = "details")
    public String getCustomer(){
        return "Welcome Home" ;
    }

    @RequestMapping(value = "salary", method = RequestMethod.POST)
    public String salary(){
        return "Salary Obtained";

    }
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String creatCustomer(@RequestBody Customer customer){
        String name = customer.getName();
        int id = customer.getId();
        String depart = customer.getDepartment();
        return name + " " + id + " " + depart ;

    }
    @RequestMapping(value = "put", method = RequestMethod.PUT)
    public String updateCustomer(@RequestBody Customer customer){
        String name = customer.getName();
        int id = customer.getId();
        String depart = customer.getDepartment();
        return name + " " + id + " " + depart ;

    }
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public String deleteCustomer(@RequestBody Customer customer){
        String name = customer.getName();
        int id = customer.getId();
        String depart = customer.getDepartment();
        return "Customer has been deleted";

    }
    @RequestMapping(value = "salary/{name}/{id}/{depart}", method = RequestMethod.GET)
    public String customerPathVariable(@PathVariable String name,
                                       @PathVariable int id,
                                       @PathVariable String depart){
       log.info("Path Variable : name {}, id {}, depart{}", name, id, depart);
        return "Customer Path Variable : "+ name+ " with Id Number is  " + id + " " + depart + " department" ;

    }

    @RequestMapping(value = {"require","require/{id}"}, method = RequestMethod.GET)
    public String customerRequiredPathVariable(@PathVariable(required = false) Integer id) {
        if ( id != null) {
            String name = "Sudip Pradhan";
            String depart = " Mechanical";
            log.info("Path Variable: name{}, id{}, depart{}", name, id, depart);
            return "Customer Details has been added of Id Number " + id + " " + name + "  "+ depart + "department" ;
        } else {
            return "Nothing to be printed";
        }

    }

    @RequestMapping(value = "address", method = RequestMethod.GET)
    public String customerAddress(@RequestParam(name = "name", defaultValue = "Sudip") String name,
                                  @RequestParam(name = "id", defaultValue = "56") Integer id,
                                  @RequestParam(name = "depart", defaultValue = "Mechanical") String depart
                                  ) {
        return "Welcome " + name + " your id Number is " + id + depart + " department " ;
    }

}
