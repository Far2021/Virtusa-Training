package com.example.Register.controller;

import org.springframework.stereotype.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.Register.domain.Register;
import com.example.Register.service.StudentService;
 
@Controller
public class StudentController {

	@Autowired
    private StudentService service;
 
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Register> listregister = service.listAll();
        model.addAttribute("listregister", listregister);
        System.out.print("Get / indexing");
        return "index";
    }
 
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("register", new Register());
        return "new";
    }
 
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRegister(@ModelAttribute("register") Register std) {
        service.save(std);
        return "redirect:/";
    }
 
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditRegisterPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Register std = service.get(id);
        mav.addObject("register", std);
        return mav;
        
    }
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}

