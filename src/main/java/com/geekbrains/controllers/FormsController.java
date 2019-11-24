package com.geekbrains.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormsController {

    @RequestMapping("/show_simple_form")
    public String showSimpleForm() {
        return "simple_form";
    }

    @RequestMapping(path = "/simple_form_processing", method = RequestMethod.GET)
    public String simpleProcessForm() {
        return "simple_form_result";
    }

    @RequestMapping("/show_mod_form")
    public String showModForm() {
        return "mod_form";
    }

    @RequestMapping(path = "/mod_form_processing", method = RequestMethod.GET)
    public String modProcessForm(@RequestParam("studentName") String studentName,@RequestParam("studentAge") String studentAge, Model model) {
        studentName = "Modified: " + studentName;
        studentAge = "Modified: " + studentAge;
        model.addAttribute("studentName", studentName);
        model.addAttribute("studentAge", studentAge);
        return "mod_form_result";
    }
}
