package com.vss.RealEstate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/properties")
public class PropertiesController {
	
	@GetMapping({ "", "/" })
    public String properties(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "properties"; // loads templates/properties.html
    }

    @GetMapping("/property-single")
    public String propertySingle(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "property-single"; // loads templates/property-single.html
    }

    @GetMapping("/property-single2")
    public String propertySingle2(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "property-single2"; // loads templates/property-single.html
    }

}
