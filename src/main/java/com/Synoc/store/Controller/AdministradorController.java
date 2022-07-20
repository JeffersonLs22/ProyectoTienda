package com.Synoc.store.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Synoc.store.Model.Producto;
import com.Synoc.store.Service.ProductoService;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {
	
	
	@Autowired
	private  ProductoService productoService;
	
	
	@GetMapping("")
	public String home(Model model) {
		//CONESTO PASARA A LA VISTA HOME
		
	List<Producto>productos=productoService.findAll();
	model.addAttribute("productos",productos);
		return "Administrador/home_admin";
	}
	


}
