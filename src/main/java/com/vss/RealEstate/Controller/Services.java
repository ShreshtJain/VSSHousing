package com.vss.RealEstate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/services")
public class Services {
	
	@GetMapping({ "", "/" })
    public String services(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "services"; // loads templates/services.html
    }
	
    @GetMapping("/service-details")
    public String serviceDetails(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "service-details"; // loads templates/service-details.html
    }
    

    

}
