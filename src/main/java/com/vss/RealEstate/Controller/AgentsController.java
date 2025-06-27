package com.vss.RealEstate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agents")
public class AgentsController {
	
	@GetMapping({ "", "/" })
    public String agents(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "agents"; // loads templates/agents.html
    }

}
