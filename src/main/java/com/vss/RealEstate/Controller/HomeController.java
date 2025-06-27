package com.vss.RealEstate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	
    @GetMapping({ "", "/" })
    public String home(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "index"; // loads templates/home.html
    }
	
    
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "about"; // loads templates/home.html
    }

    
    @GetMapping("/agents")
    public String agents(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "agents"; // loads templates/home.html
    }

    @GetMapping("/properties")
    public String properties(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "properties"; // loads templates/home.html
    }

    @GetMapping("/property-single")
    public String propertySingle(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "property-single"; // loads templates/home.html
    }
    
    @GetMapping("/service-details")
    public String serviceDetails(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "service-details"; // loads templates/home.html
    }
    
    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "services"; // loads templates/home.html
    }
    
    
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "contact"; // loads templates/home.html
    }

}
