package kg.megacom.student.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class HomeController {
    @GetMapping
    public String homePage(Model model){
        model.addAttribute("title","It School megacom");
        return "home";
    }
}
