package com.Synoc.store.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/crear")
public class CreateController {
	
	
	@GetMapping("")
	public String crear() {
		
		return "producto/crear";
		
	}

}
