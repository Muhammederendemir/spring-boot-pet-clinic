package com.springbootpetclinic.web;

import com.springbootpetclinic.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetClinicController {

    @Autowired //bootstrap sırasında PetClinicService tipindeki beanı Controller Beanımıza enjekte edecek
    private PetClinicService petClinicService;

    @RequestMapping("/owners")
    public ModelAndView getOwners() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("owners", petClinicService.findOwners());
        mav.setViewName("owners");
        return mav;
    }

    @RequestMapping("start")
    @ResponseBody
    public String welcome() {
        return "PetClinic uygulaması";
    }

    @RequestMapping("/login.html")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        return mav;
    }


    @RequestMapping({"/", "/index.html"})
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}