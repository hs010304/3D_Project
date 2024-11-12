package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main_Controller {

	@GetMapping("/best")
	public String best() {
		return "best";
	}

	

	@GetMapping("/new")
	public String new1() {
		return "new";
	}

	@GetMapping("/notice")
	public String notice() {
		return "notice";
	}

	@GetMapping("/wishlist")
	public String wishlist() {
		return "wishlist";
	}

	@GetMapping("/detail")
	public String detail() {
		return "detail";
	}

	@GetMapping("/buy")
	public String buy() {
		return "buy";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@GetMapping("/payment")
	public String payment() {
		return "payment";
	}

	@GetMapping("/index")
	        public String index() {
	            return "index";
	}	
	@GetMapping("/showroom")
    public String showroom() {
        return "showroom";
    }
	
	@GetMapping("/cart")
    public String cart() {
        return "cart";
    }
	
}
