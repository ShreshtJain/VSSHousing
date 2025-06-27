package com.vss.RealEstate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
    @GetMapping({ "/home", "/home/" })
    public String home(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "index"; // loads templates/home.html
    }
    
    @GetMapping({ "", "/" })
    public String redirectToHome() {
        return "redirect:/home";
    }

}
