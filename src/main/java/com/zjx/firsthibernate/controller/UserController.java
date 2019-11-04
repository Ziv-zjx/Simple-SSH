package com.zjx.firsthibernate.controller;

import com.alibaba.fastjson.JSON;
import com.zjx.firsthibernate.service.IPeopleService;
import com.zjx.firsthibernate.pojo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
    
    @RequestMapping(value = "/print", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("Name", "郑家祥");
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }

    @Autowired
    private IPeopleService peopleService;

    @ResponseBody
    @RequestMapping(value = "/savePeople")
    public String savePeople()
    {
        Long id = peopleService.savePerson();

        return "success，返回的主键是"+id;
    }
    @ResponseBody
    @RequestMapping(value = "getModel",method = RequestMethod.GET)
    public String getModel(long id){
        People people = peopleService.get(id);

        return JSON.toJSONString(people);
    }

    @ResponseBody
    @RequestMapping(value = "updateModel",method = RequestMethod.GET)
    public String updateModel(long id){

       People people = peopleService.updateAddress(id);

       return JSON.toJSONString(people);
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public void delete(Long id){
        peopleService.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "evict",method = RequestMethod.GET)
    public String evict(Long id){

        People people = peopleService.get(id);
        peopleService.evict(people);
        People people1 = peopleService.get(id);
        return  JSON.toJSONString(people1);
    }

    @ResponseBody
    @RequestMapping(value = "load",method = RequestMethod.GET)
    public String load(Long id){
        return JSON.toJSONString(peopleService.load(id));
    }
}
