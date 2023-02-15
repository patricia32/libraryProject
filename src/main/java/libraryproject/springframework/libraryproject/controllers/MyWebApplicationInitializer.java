package libraryproject.springframework.libraryproject.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class MyWebApplicationInitializer{


    @RequestMapping("")
    public String getBooks(Model model){

        model.addAttribute("Main");
        return "bb";
    }

}