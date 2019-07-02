package com.springbootpetclinic.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PetClinicController {
    @RequestMapping("start")
    @ResponseBody
    public String welcome() {
        return "PetClinic uygulaması";
    }
}
