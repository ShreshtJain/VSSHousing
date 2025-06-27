package com.vss.RealEstate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutContoller {
	
	@GetMapping({ "", "/" })
    public String about(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "about"; // loads templates/about.html
    }

}
