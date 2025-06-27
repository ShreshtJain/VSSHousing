package com.vss.RealEstate.Controller;

import jakarta.validation.Valid;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.vss.RealEstate.Model.ContactForm;

@Controller
@RequestMapping("/contact")
public class ContactController {

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

        return ResponseEntity.ok("OK"); // Required by validate.js
    }
    
}
