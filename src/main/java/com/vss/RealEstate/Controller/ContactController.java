package com.vss.RealEstate.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.vss.RealEstate.Model.ContactForm;
import com.vss.RealEstate.Service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@Value("${spring.mail.username}") 
	private String supportMail;
	
	@Autowired
	 private final ContactService contactService;
	
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    
	@GetMapping({ "", "/" })
    public String showForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact"; // → contact.html
    }

    @PostMapping({ "", "/" }) // Matches the `action` in the HTML
    @ResponseBody
    public ResponseEntity<String> submitForm(@Valid ContactForm form, BindingResult result) throws InterruptedException {
    	   	
        if (result.hasErrors()) {
            // Return plain text message (validate.js expects this)
            String errors = result.getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .collect(Collectors.joining(", "));
   
            return ResponseEntity.badRequest().body(errors);
        }

        // TODO: Email sending or DB logic here
        contactService.sendEmail(supportMail,form);

        return ResponseEntity.ok("OK"); // Required by validate.js
    }
    
}
