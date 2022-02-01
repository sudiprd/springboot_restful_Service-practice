package com.example.requestmapping.controller;

import com.example.requestmapping.service.App;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@RequestMapping(value = "app")
@ResponseBody

public class AppController{

    @GetMapping(value = "details")
    public String getApplication(){
        return "Welcome to Wilbur's App" ;
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String getApp(){
        return "App Configuration are Obtained";

    }
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String creatApp(@RequestBody App app){
        String appName = app.getAppName();
        int id = app.getAppId();
        String build = app.getBuildDate();
        return "New App has been created " +
                appName + " App name " +
                " and build Id is " + id +
                " created on " + build ;

    }
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public String updateApp(@RequestBody App app){
        String appName = app.getAppName();
        int id = app.getAppId();
        String build = app.getBuildDate();
        return "App has updated Successfully " +
                appName + " App name " +
                " and its Build Id is  " + id +
                " updated on " + build ;

    }
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public String deleteApp(@RequestBody App app){
        String appName = app.getAppName();
        int id = app.getAppId();
        String build = app.getBuildDate();
        return  id + " Provided Id has been removed successfully ";

    }
    @RequestMapping(value = "app/{name}/{id}/{build}", method = RequestMethod.GET)
    public String appPathVariable(@PathVariable String appName,
                                  @PathVariable int id,
                                  @PathVariable String build){
        log.info("Path Variable : name {}, id {}, build{}", appName, id, build);
        return "App Path Variable : "+ appName+ " with Id Number " + id ;

    }

    @RequestMapping(value = {"required","required/{id}"}, method = RequestMethod.GET)
    public String appRequiredPathVariable(@PathVariable(required = false) Integer id) {
        if (id != null) {

            String appName = "Apple";
            String buildDate = "23-March-2021";

            log.info("Path Variable: appName{}, id{}, build{}", appName, id, buildDate);
            return "Required Path Variable Method has successfully Run";
        } else {
            return "Nothing to be printed";
        }

    }

    @RequestMapping(value = "brand", method = RequestMethod.GET)
    public String appBrandName(@RequestParam(name = "name") String name) {
        return "Welcome " + name;
    }
    @RequestMapping(value = "company", method = RequestMethod.GET)
    public String appCompany(@RequestParam(name = "name", defaultValue = "Sudip") String name) {
        return "Welcome " + name;
    }

}
